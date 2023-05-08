package com.raisetech.mybatishandson.controller;

import com.raisetech.mybatishandson.dto.SongDto;
import com.raisetech.mybatishandson.entity.Song;
import com.raisetech.mybatishandson.form.InsertForm;
import com.raisetech.mybatishandson.form.UpdateForm;
import com.raisetech.mybatishandson.service.SongsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongsController {

    private final SongsService songsService;

    public SongsController(SongsService songsService) {
        this.songsService = songsService;
    }

    @GetMapping
    public List<Song> getAllSongs() {
        return songsService.findAll().stream().toList();
    }

    @GetMapping
    public List<Song> getFindByYear(@RequestParam("year") int year) throws Exception {
        return songsService.findByYear(year).stream().toList();
    }


    @PostMapping
    public ResponseEntity create(@Validated @RequestBody InsertForm insertForm) {
        SongDto sdto = new SongDto(
                insertForm.getTitle(),
                insertForm.getArtist(),
                insertForm.getYear());
        int newSongId = songsService.save(sdto);
        URI location = UriComponentsBuilder.fromUriString("http://localohost:8080/create/" + newSongId)
                .build().toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") int id,
                                 @Validated @RequestBody UpdateForm updateForm) throws Exception {
        SongDto sdto = new SongDto(
                updateForm.getTitle(),
                updateForm.getArtist(),
                updateForm.getYear());
        Song song = songsService.update(id, sdto);
        return ResponseEntity.ok(song);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSong(@PathVariable("id") int id) throws Exception {
        songsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
