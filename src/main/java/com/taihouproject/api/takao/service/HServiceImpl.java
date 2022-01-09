package com.taihouproject.api.takao.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.taihouproject.api.takao.model.HEntity;
import com.taihouproject.api.takao.repository.HRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HServiceImpl implements HService {
    @Autowired 
    private HRepository repository;
    @Autowired
    private MongoTemplate templateCustom;

    @Override
    public HEntity findById(String id) {
        Optional<HEntity> res = repository.findById(id);
        if(res.isPresent()){
            return res.get();
        }
        return new HEntity();
    }

    @Override
    public List<HEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<HEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    
    @Override
    public List<HEntity> findAllByTitle(String title) {
        if (title.length() > 1){
            return repository.findAllByTitleRegex(title);
        }
        return new ArrayList<HEntity>();
    }

    @Override
    public List<HEntity> findAllBySeries(String series) {
        return repository.findAllBySeries(series);
    }
    
    @Override
    public List<HEntity> findAllByGenres(String genres) {
        if(genres != null && genres.length() > 2){
            List<String> genresList = new ArrayList<>();
            for (String genre : genres.split(",")) {
                genresList.add(genre.trim());
            }
            return templateCustom.find(
                Query.query(Criteria.where("genres").all(genresList)), HEntity.class);
        }
        return new ArrayList<HEntity>();
    }

    @Override
    public List<HEntity> findAllByCharacters(String characters) {
        if(characters != null && characters.length() > 2){
            List<String> charactersList = new ArrayList<>();
            for (String character : characters.split(",")) {
                charactersList.add(character.trim());
            }
            return templateCustom.find(
                Query.query(Criteria.where("characters").all(charactersList)), HEntity.class);
        }
        return new ArrayList<HEntity>();
    }

    @Override 
    public HEntity insertH(String title, String series, String type, String language, Integer year, List<String> images, List<String> thumbnails, List<String> genres, List<String> characters){
        HEntity doc = new HEntity(title, series, type, language, year, images, thumbnails, genres, characters, new Date());
        return repository.save(doc);
    }

}
