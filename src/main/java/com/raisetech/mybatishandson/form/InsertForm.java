package com.raisetech.mybatishandson.form;

import jakarta.validation.constraints.*;

public class InsertForm {

    @NotEmpty
    @Size(max = 100)
    private String title;

    @NotEmpty
    @Size(max = 100)
    private String artist;

    @NotEmpty
    @Pattern(regexp = "^\\d{4}$")
    private String year;

    public InsertForm(){};

    public InsertForm(String title, String artist, String year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String  getYear() {
        return year;
    }
}
