package com.raisetech.mybatishandson.service;

import com.raisetech.mybatishandson.dto.SongDto;
import com.raisetech.mybatishandson.entity.Song;
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
    public List<Song> getSongs(Integer year) {
        if (year == null) {
            return songsMapper.findAll().stream().toList();
        }
        List<Song> songs = this.songsMapper.findByYear(year);
        if (songs.isEmpty()) {
            throw new ResourceNotFoundException(year + "年の曲は登録されていません。");
        } else {
            return songs.stream().toList();
        }

    }

    @Override
    public int save(SongDto sdto) {
        songsMapper.save(sdto);
        return sdto.getId();
    }

    @Override
    public Song update(int id, SongDto sdto) {
        Song song = songsMapper.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("id:" + id + "番の曲が見つかりません。"));
        if (sdto.getTitle() == null) {
            sdto.setTitle(song.getTitle());
        }
        if (sdto.getArtist() == null) {
            sdto.setArtist(song.getArtist());
        }
        if (sdto.getYear() == null) {
            sdto.setYear(song.getYear());
        }
        songsMapper.update(id, sdto);
        Song updateSong = songsMapper.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("id:" + id + "番の曲が見つかりません。"));
        return updateSong;
    }

    @Override
    public void deleteById(int id) {
        songsMapper.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("id:" + id + "番の曲が見つかりません。"));
        songsMapper.deleteById(id);
    }


}
