package com.raisetech.mybatishandson.service;

import com.raisetech.mybatishandson.dto.SongsDTO;
import com.raisetech.mybatishandson.entity.Songs;

import java.util.List;


public interface SongsService {
    List<Songs> findAll();

    List<Songs> findByYear(int year) throws Exception;

    int save(SongsDTO sdto);

    Songs update(int id, SongsDTO sdto);

    void deleteById(int id) throws Exception;
}
