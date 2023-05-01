package com.raisetech.mybatishandson.controller;

import com.raisetech.mybatishandson.dto.SongsDto;
import com.raisetech.mybatishandson.entity.Songs;
import com.raisetech.mybatishandson.form.InsertForm;
import com.raisetech.mybatishandson.form.UpdateForm;
import com.raisetech.mybatishandson.service.SongsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

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
    public List<Songs> getFindByYear(@RequestParam("year") int year) throws Exception {
        return songsService.findByYear(year).stream().toList();
    }


    @PostMapping("/create")
    public ResponseEntity create(@Validated @RequestBody InsertForm insertForm) {
        SongsDto sdto = new SongsDto(
                insertForm.getTitle(),
                insertForm.getArtist(),
                insertForm.getYear());
        int newSongId = songsService.save(sdto);
        URI location = UriComponentsBuilder.fromUriString("http://localohost:8080/create/" + newSongId)
                .build().toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id") int id,
                                 @Validated @RequestBody UpdateForm updateForm) throws Exception {
        SongsDto sdto = new SongsDto(
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
