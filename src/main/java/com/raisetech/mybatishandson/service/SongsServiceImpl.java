package com.raisetech.mybatishandson.service;

import com.raisetech.mybatishandson.dto.SongsDTO;
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
    public List<Songs> findByYear(int year) {
        List<Songs> songs = this.songsMapper.findByYear(year);
        if (songs.isEmpty()) {
            throw new ResourceNotFoundException(year + "年の曲は登録されていません。");
        } else {
            return songs;
        }
    }

    @Override
    public int save(SongsDTO sdto) {
        songsMapper.save(sdto);
        return sdto.getId();
    }

    @Override
    public Songs update(int id, SongsDTO sdto) {
        songsMapper.update(id, sdto);
        Songs songs = songsMapper.findById(id).orElseThrow(() -> new ResourceNotFoundException("id:" + id + "番の曲が見つかりません。"));
        return songs;
    }

    @Override
    public void deleteById(int id) {
        Optional<Songs> songs = songsMapper.findById(id);
        songs.orElseThrow(() -> new ResourceNotFoundException("id:" + id + "番の曲が見つかりません。"));
        songsMapper.deleteById(id);
    }


}
