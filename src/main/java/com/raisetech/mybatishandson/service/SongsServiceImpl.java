package com.raisetech.mybatishandson.service;

import com.raisetech.mybatishandson.entity.Songs;
import com.raisetech.mybatishandson.exception.ResourceNotFoundException;
import com.raisetech.mybatishandson.mapper.SongsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongsServiceImpl implements SongsService {
    private SongsMapper songsMapper;

    public SongsServiceImpl(SongsMapper songsMapper) {
        this.songsMapper = songsMapper;
    }

    @Override
    public List<Songs> findAll() {
        return songsMapper.findAll();
    }

    @Override
    public Songs findByYear(int year){
        Optional<Songs> songs = this.songsMapper.findByYear(year);
        if (songs.isPresent()){
           return songs.get();
        } else {
            throw new ResourceNotFoundException(year + "年の曲は登録されていません。");
        }
    }
    @Override
    public Songs save(Songs songs){
        songsMapper.save(songs);
        return songs;
    }

    @Override
    public void deleteById(int id) {
        Optional<Songs> songs = songsMapper.findById(id);
        songs.orElseThrow(() -> new ResourceNotFoundException("id:" + id + "の曲が見つかりません。"));
        songsMapper.deleteById(id);
    }


}
