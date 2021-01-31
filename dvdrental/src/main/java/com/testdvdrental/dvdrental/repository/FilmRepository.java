package com.testdvdrental.dvdrental.repository;

import com.testdvdrental.dvdrental.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository  extends JpaRepository<FilmEntity, Integer> {

    List<FilmEntity> findByOrderByFilmIdAsc();
    List<FilmEntity> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);
    FilmEntity findByFilmId(Integer filmId);

}
