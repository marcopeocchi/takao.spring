package com.taihouproject.api.takao.controller;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taihouproject.api.takao.model.LoginDTO;
import com.taihouproject.api.takao.model.TokenEntity;
import com.taihouproject.api.takao.model.UserEntity;
import com.taihouproject.api.takao.security.JWTProvider;
import com.taihouproject.api.takao.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(value="/api/v1/auth", produces = MediaType.APPLICATION_JSON_VALUE) 
public class AuthenticationController { 

    @Autowired 
    private UserService userService; 
    
    @PostMapping
    public ResponseEntity<TokenEntity> signin(@RequestBody LoginDTO body) { 
        // verifica se l'utente è registrato su db
        UserEntity user = userService.findByUsernameAndPassword(body.getUsername());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Map<String, JsonNode> claimMap = new HashMap<>();
        claimMap.put("user", new ObjectMapper().valueToTree(user));

        String jwt = JWTProvider.createJwt(user.getUsername(), claimMap);
        TokenEntity tokenDTO = new TokenEntity();
        tokenDTO.setToken(jwt);
        return ResponseEntity.ok(tokenDTO); 
    } 
}