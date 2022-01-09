package com.taihouproject.api.takao.repository;

import java.util.List;

import com.taihouproject.api.takao.model.HEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HRepository extends MongoRepository<HEntity, String> {
	/*
		findById already defined in MongoRepository
	*/
    public HEntity       findByTitle         (String title);
    public List<HEntity> findAllByTitleRegex (String title);
    public List<HEntity> findAllBySeries     (String series);
    public List<HEntity> findAllByGenres     (List<String> genres);
    public List<HEntity> findAllByCharacters (List<String> characters);

}
