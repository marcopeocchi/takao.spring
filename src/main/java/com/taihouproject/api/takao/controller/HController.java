package com.taihouproject.api.takao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.taihouproject.api.takao.model.HDTO;
import com.taihouproject.api.takao.model.HEntity;
import com.taihouproject.api.takao.service.HService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/h", produces = MediaType.APPLICATION_JSON_VALUE)
public class HController {
    
    @Autowired
    private HService hService;

    @GetMapping("/")
    public ResponseEntity<Map<String,Object>> index(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "16") int size) {
        try {
            List<HEntity> hs = new ArrayList<HEntity>();
            Pageable paging = PageRequest.of(page, size, Sort.by("id").descending());
            
            Page<HEntity> pageH;
            pageH = hService.findAll(paging);
            hs = pageH.getContent();
      
            Map<String, Object> response = new HashMap<>();
            response.put("data", hs);
            response.put("currentPage", pageH.getNumber());
            response.put("totalItems", pageH.getTotalElements());
            response.put("totalPages", pageH.getTotalPages());
      
            return ResponseEntity.ok().body(response);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<HEntity> byId(@PathVariable String id) {
        return ResponseEntity.ok().body(hService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<HEntity>> all() {
        return ResponseEntity.ok().body(hService.findAll());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<HEntity>> byTitle(@PathVariable String title) {
        return ResponseEntity.ok().body(hService.findAllByTitle(title));
    }

    @GetMapping("/series/{series}")
    public ResponseEntity<List<HEntity>> bySeries(@PathVariable String series) {
        return ResponseEntity.ok().body(hService.findAllBySeries(series));
    }

    @GetMapping("/genres/{genres}")
    public ResponseEntity<List<HEntity>> byGenres(@PathVariable String genres) {
        return ResponseEntity.ok().body(hService.findAllByGenres(genres));
    }

    @GetMapping("/characters/{characters}")
    public ResponseEntity<List<HEntity>> byCharacters(@PathVariable String characters) {
        return ResponseEntity.ok().body(hService.findAllByCharacters(characters));
    }

    @PostMapping("/")
    public ResponseEntity<HEntity> insert(@RequestBody HDTO body) {
        HEntity res = hService.insertH(
            body.getTitle(),
            body.getSeries(),
            body.getType(),
            body.getLanguage(),
            body.getYear(),
            body.getImages(),
            body.getThumbnails(),
            body.getGenres(),
            body.getCharacters()
        );
        if(res != null){
            return ResponseEntity.ok().body(res);
        }
        return ResponseEntity.ok().body(new HEntity());
    }

}

