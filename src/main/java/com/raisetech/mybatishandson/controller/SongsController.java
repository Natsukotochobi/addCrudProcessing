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

import java.time.ZonedDateTime;
import java.util.*;

@RestController
public class SongsController {

    private final SongsService songsService;

    public SongsController(SongsService songsService) {
        this.songsService = songsService;
    }

    @GetMapping("/songs")
    public List<Songs> getTitles() {
        return songsService.findAll().stream().toList();
    }

    @GetMapping("/search")
    public Optional<Songs> getSongsList(@RequestParam("published_year") int published_year) throws Exception {
        return Optional.ofNullable(this.songsService.findSongsInfo(published_year));
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timeStamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }
    @PostMapping("/create")
    public void create(@Validated @RequestBody Songs songs){
            songsService.save(songs);
        }

    @ExceptionHandler
    //@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        Map<String, String> invalidParam = new HashMap<>();
        for (FieldError e : ex.getFieldErrors()) {
            //logger.error(e.getField() + " : " + e.getDefaultMessage());
            invalidParam.put(e.getField(), e.getDefaultMessage());
        }
        Map<String, Object> body = Map.of(
                "timeStamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "message", invalidParam
        );


        return ResponseEntity.badRequest().body(body);

    }
}
