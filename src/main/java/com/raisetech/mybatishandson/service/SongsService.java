package com.raisetech.mybatishandson.service;

import com.raisetech.mybatishandson.entity.Songs;

import java.util.List;
import java.util.Optional;


public interface SongsService {
    List<Songs> findAll();

    Songs findSongsInfo(int year) throws Exception;

    void save(Songs songs);

    void deleteById(int id) throws Exception;
}
