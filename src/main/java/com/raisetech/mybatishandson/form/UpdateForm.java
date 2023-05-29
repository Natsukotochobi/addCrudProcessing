package com.raisetech.mybatishandson.form;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateForm {

    @Size(max = 100)
    private String title;

    @Size(max = 100)
    private String artist;

    @Pattern(regexp = "^\\d{4}$")
    private String year;

}
