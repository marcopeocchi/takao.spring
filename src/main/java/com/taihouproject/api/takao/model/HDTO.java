package com.taihouproject.api.takao.model;

import java.util.Date;
import java.util.List;


public class HDTO {

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
