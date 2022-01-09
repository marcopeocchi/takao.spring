package com.taihouproject.api.takao.service;

import com.taihouproject.api.takao.model.UserEntity;


public interface UserService {

    UserEntity findByUsernameAndPassword(String username);

}
