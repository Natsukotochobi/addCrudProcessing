package com.raisetech.mybatishandson.service;

import com.raisetech.mybatishandson.dto.SongDto;
import com.raisetech.mybatishandson.entity.Song;
import java.util.List;


public interface SongsService {

    List<Song> getSongs(Integer year) throws Exception;

    int save(SongDto sdto);

    Song update(int id, SongDto sdto);

    void deleteById(int id) throws Exception;
}
