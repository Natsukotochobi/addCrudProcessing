package com.raisetech.mybatishandson.service;

import com.raisetech.mybatishandson.entity.Songs;
import com.raisetech.mybatishandson.exception.ResourceNotFoundException;
import com.raisetech.mybatishandson.mapper.SongsMapper;
import org.apache.ibatis.javassist.NotFoundException;
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
    public Songs findSongsInfo(int year){
        Optional<Songs> songs = this.songsMapper.findById(year);
        if (songs.isPresent()){
           return songs.get();
        } else {
            throw new ResourceNotFoundException(year + "年の曲は登録されていません。");
        }
    }
    @Override
    public void save(Songs songs){
        songsMapper.save(songs);
    }

    @Override
    public void deleteById(int id){
        Optional<Songs> songs = songsMapper.findById(id);
        songs.orElseThrow(() -> new ResourceNotFoundException("id:" + id + "の曲が見つかりません。"));
        songsMapper.deleteById(id);
    }


}
