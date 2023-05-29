package com.raisetech.mybatishandson.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
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

}
