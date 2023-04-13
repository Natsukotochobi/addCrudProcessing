package com.raisetech.mybatishandson.dto;

public class SongsDTO {
    private int id;
    private String title;
    private String artist;
    private int year;

    public SongsDTO(String title, String artist, int year) {
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

    public int getYear() {
        return year;
    }
}
