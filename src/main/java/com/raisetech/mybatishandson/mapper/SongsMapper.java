package com.raisetech.mybatishandson.mapper;

import com.raisetech.mybatishandson.dto.SongsDTO;
import com.raisetech.mybatishandson.entity.Songs;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper // MyBatisのMapperである目印として@Mapperアノテーションを付与する
public interface SongsMapper {
 @Select("SELECT * FROM songs")
 List<Songs> findAll();

 @Select("SELECT * FROM songs WHERE year = #{year}")
 Optional<Songs> findByYear(int year);

 @Select("SELECT * FROM songs WHERE id = #{id}")
 Optional<Songs> findById(int id);

 @Insert("INSERT INTO songs(title, artist, year) VALUES (#{title}, #{artist}, #{year})")
 @Options(useGeneratedKeys = true, keyColumn = "id")
 SongsDTO save(SongsDTO songsDTO);
 @Delete("DELETE FROM songs WHERE id = #{id}")
 void deleteById(int id);
}
