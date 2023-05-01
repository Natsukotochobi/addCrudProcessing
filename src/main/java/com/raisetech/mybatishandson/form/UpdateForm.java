package com.raisetech.mybatishandson.form;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public class UpdateForm {

    @Size(max = 100)
    private String title;

    @Size(max = 100)
    private String artist;

    @Pattern(regexp = "^\\d{4}$")
    private String year;

    public UpdateForm() {
    }


    public UpdateForm(String title, String artist, String year) {
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

    public String getYear() {
        return year;
    }
}
