package com.raisetech.mybatishandson.dto;

public class SongsDto {
    private int id;
    private String title;
    private String artist;
    private String year;

    public SongsDto(String title, String artist, String year) {
        this.id = 0;
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

    public String getYear() {
        return year;
    }
}
