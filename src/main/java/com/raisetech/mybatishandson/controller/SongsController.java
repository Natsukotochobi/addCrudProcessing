package com.raisetech.mybatishandson.controller;

import com.raisetech.mybatishandson.entity.Songs;
import com.raisetech.mybatishandson.exception.ResourceNotFoundException;
import com.raisetech.mybatishandson.service.SongsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.*;

@RestController
public class SongsController {

    private final SongsService songsService;

    public SongsController(SongsService songsService) {
        this.songsService = songsService;
    }

    @GetMapping("/songs")
    public List<Songs> getAllSongs() {
        return songsService.findAll().stream().toList();
    }

    @GetMapping("/search")
    public Optional<Songs> getFindByYear(@RequestParam("published_year") int published_year) throws Exception {
        return Optional.ofNullable(this.songsService.findByYear(published_year));
    }


    @PostMapping("/create")
    public ResponseEntity create(@Validated @RequestBody Songs songs){
        songsService.save(songs);
        URI location = UriComponentsBuilder.fromUriString("http://localohost:8080/create/" + songs.getId())
                .build().toUri();
        return ResponseEntity.created(location).build();
        }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSong(@PathVariable("id") int id) throws Exception {
        songsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
