package com.raisetech.mybatishandson.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongDto {
    @Setter(AccessLevel.NONE)
    private int id;
    private String title;
    private String artist;
    private String year;

    public SongDto(String title, String artist, String year) {
        this.id = 0;
        this.title = title;
        this.artist = artist;
        this.year = year;
    }
}
