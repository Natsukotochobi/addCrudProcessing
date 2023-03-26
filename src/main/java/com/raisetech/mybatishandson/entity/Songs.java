package com.raisetech.mybatishandson.entity;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

public class Songs {

    private int id;
    @NotEmpty
    @Size(max = 100)
    private String title;
    @NotEmpty
    @Size(max = 100)
    private String artist;
    @Digits(integer = 4,fraction = 0)
    @Positive
    private int year;

    public Songs(){}

    public Songs(int id, String title, String artist, int year) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
