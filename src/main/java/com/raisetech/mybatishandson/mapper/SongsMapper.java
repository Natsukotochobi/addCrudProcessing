package com.raisetech.mybatishandson.mapper;

import com.raisetech.mybatishandson.dto.SongDto;
import com.raisetech.mybatishandson.entity.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Options;
import java.util.List;
import java.util.Optional;

@Mapper // MyBatisのMapperである目印として@Mapperアノテーションを付与する
public interface SongsMapper {
    @Select("SELECT * FROM songs")
    List<Song> findAll();

    @Select("SELECT * FROM songs WHERE year = #{year}")
    List<Song> findByYear(Integer year);

    @Select("SELECT * FROM songs WHERE id = #{id}")
    Optional<Song> findById(int id);

    @Insert("INSERT INTO songs(title, artist, year) VALUES (#{title}, #{artist}, #{year})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(SongDto sdto);

    @Update("UPDATE songs SET title = #{sdto.title}, artist = #{sdto.artist}, year = #{sdto.year} "
            + "WHERE id = #{id}")
    void update(int id, SongDto sdto);

    @Delete("DELETE FROM songs WHERE id = #{id}")
    void deleteById(int id);
}
