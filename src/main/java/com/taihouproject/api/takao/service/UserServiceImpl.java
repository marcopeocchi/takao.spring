package com.taihouproject.api.takao.service;

import com.taihouproject.api.takao.model.UserEntity;
import com.taihouproject.api.takao.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository repository;

    public UserEntity findByUsernameAndPassword(String username){
        return repository.findByUsername(username);
    }
}
