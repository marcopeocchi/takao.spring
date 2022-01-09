package com.taihouproject.api.takao.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "mangas")
public class HEntity {
    @Id    
    private String       id;
    private String       title;
    private String       series;
    private String       type;
    private String       language;
    private Integer      year;
    private List<String> images;
    private List<String> thumbnails;
    private List<String> genres;
    private List<String> characters;
    private Date         uploaded;

    public HEntity(){
        this.title      = "";
        this.series     = "";
        this.type       = "";
        this.language   = "";
        this.year       = null;
        this.images     = null;
        this.thumbnails = null;
        this.genres     = null;
        this.characters = null;
        this.uploaded   = (uploaded != null) ? uploaded : new Date();
    }

    public HEntity(String title, String series, String type, String language, Integer year, List<String> images, List<String> thumbnails, List<String> genres, List<String> characters, Date uploaded){
        this.title      = title;
        this.series     = series;
        this.type       = type;
        this.language   = language;
        this.year       = year;
        this.images     = images;
        this.thumbnails = thumbnails;
        this.genres     = genres;
        this.characters = characters;
        this.uploaded   = (uploaded != null) ? uploaded : new Date();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeries() {
        return this.series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getThumbnails() {
        return this.thumbnails;
    }

    public void setThumbnails(List<String> thumbnails) {
        this.thumbnails = thumbnails;
    }

    public List<String> getGenres() {
        return this.genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getCharacters() {
        return this.characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public Date getUploaded() {
        return this.uploaded;
    }

    public void setUploaded(Date uploaded) {
        this.uploaded = uploaded;
    }

    @Override
    public String toString() {
        return String.format("HEntity[ id=%s, title=%s, series=%s, type=%s, language=%s, year=%s, images=%s, thumbnails=%s, characters=%s, uploaded=%s ]",
            title, series, type, language, year, images, thumbnails, genres, characters, uploaded
        );
    }
}
