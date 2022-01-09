package com.taihouproject.api.takao.service;

import java.util.List;

import com.taihouproject.api.takao.model.HEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface HService {

    HEntity       findById            (String id);
    List<HEntity> findAll             ();
    Page<HEntity> findAll             (Pageable pageable);
    List<HEntity> findAllByTitle      (String title);
    List<HEntity> findAllBySeries     (String series);
    List<HEntity> findAllByGenres     (String genres);
    List<HEntity> findAllByCharacters (String characters);
    HEntity       insertH             (String title, String series, String type, String language, Integer year, List<String> images, List<String> thumbnails, List<String> genres, List<String> characters);
}
