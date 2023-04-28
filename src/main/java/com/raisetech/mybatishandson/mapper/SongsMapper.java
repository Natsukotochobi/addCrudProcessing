package com.raisetech.mybatishandson.mapper;

import com.raisetech.mybatishandson.dto.SongsDto;
import com.raisetech.mybatishandson.entity.Songs;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Optional;

@Mapper // MyBatisのMapperである目印として@Mapperアノテーションを付与する
public interface SongsMapper {
    @Select("SELECT * FROM songs")
    List<Songs> findAll();

    @Select("SELECT * FROM songs WHERE year = #{year}")
    List<Songs> findByYear(int year);

    @Select("SELECT * FROM songs WHERE id = #{id}")
    Optional<Songs> findById(int id);

    @Insert("INSERT INTO songs(title, artist, year) VALUES (#{title}, #{artist}, #{year})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(SongsDto sdto);

    @Update("UPDATE songs SET "
            + "title = "
            + "CASE "
            + "WHEN #{sdto.title} IS NOT NULL THEN #{sdto.title} ELSE title END, "
            + "artist = "
            + "CASE "
            + "WHEN #{sdto.artist} IS NOT NULL THEN #{sdto.artist} ELSE artist END, "
            + "year = "
            + "CASE "
            + "WHEN #{sdto.year} IS NOT NULL"
            + " THEN #{sdto.year} ELSE year END "
            + "WHERE id = #{id}")
    void update(int id, SongsDto sdto);

    @Delete("DELETE FROM songs WHERE id = #{id}")
    void deleteById(int id);
}
