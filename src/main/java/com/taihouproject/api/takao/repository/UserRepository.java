package com.taihouproject.api.takao.repository;

import com.taihouproject.api.takao.model.UserEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
	/*
		findById already defined in MongoRepository
	*/
    public UserEntity findByUsername(String username);
}
