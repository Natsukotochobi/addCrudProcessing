package com.raisetech.mybatishandson.controller;

import com.raisetech.mybatishandson.dto.SongsDTO;
import com.raisetech.mybatishandson.entity.Songs;
import com.raisetech.mybatishandson.form.InsertForm;
import com.raisetech.mybatishandson.form.UpdateForm;
import com.raisetech.mybatishandson.service.SongsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    public Optional<List<Songs>> getFindByYear(@RequestParam("published_year") int published_year) throws Exception {
        return Optional.ofNullable(this.songsService.findByYear(published_year));
    }


    @PostMapping("/create")
    public ResponseEntity create(@Validated @RequestBody InsertForm insertForm){
        SongsDTO sdto = new SongsDTO(
                insertForm.getTitle(),
                insertForm.getArtist(),
                insertForm.getYear());
        int newSongId = songsService.save(sdto);
        URI location = UriComponentsBuilder.fromUriString("http://localohost:8080/create/" + newSongId)
                .build().toUri();
        return ResponseEntity.created(location).build();
        }
    @PatchMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id") int id, @Validated @RequestBody UpdateForm updateForm) throws Exception{
        SongsDTO sdto = new SongsDTO(
                updateForm.getTitle(),
                updateForm.getArtist(),
                updateForm.getYear());
        Songs songs = songsService.update(id, sdto);
        return ResponseEntity.ok(songs);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSong(@PathVariable("id") int id) throws Exception {
        songsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
