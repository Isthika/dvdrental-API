package com.testdvdrental.dvdrental.service;

import com.testdvdrental.dvdrental.dto.FilmDto;
import com.testdvdrental.dvdrental.entity.FilmEntity;

import java.util.List;

public interface FilmService {
    public List<FilmEntity> getAll();
    public FilmEntity getByFilmId(Integer id);
    public List<FilmEntity> getSearch(String title, String description);
    public FilmEntity postFilm(FilmDto dto);
    public FilmEntity putFilm(Integer film_id, FilmDto dto);
    public FilmEntity deleteFilm(Integer film_id);


}
