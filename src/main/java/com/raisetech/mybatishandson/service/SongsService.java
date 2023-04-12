package com.raisetech.mybatishandson.service;

import com.raisetech.mybatishandson.dto.SongsDTO;
import com.raisetech.mybatishandson.entity.Songs;

import java.util.List;


public interface SongsService {
    List<Songs> findAll();

    Songs findByYear(int year) throws Exception;

    SongsDTO save(SongsDTO songsDTO);

    void deleteById(int id) throws Exception;
}
