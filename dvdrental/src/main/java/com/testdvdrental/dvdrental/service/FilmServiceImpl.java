package com.testdvdrental.dvdrental.service;


import com.testdvdrental.dvdrental.dto.FilmDto;
import com.testdvdrental.dvdrental.entity.FilmEntity;
import com.testdvdrental.dvdrental.entity.LanguageEntity;
import com.testdvdrental.dvdrental.entity.Rating;
import com.testdvdrental.dvdrental.repository.FilmRepository;
import com.testdvdrental.dvdrental.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService{

    @Autowired
    private FilmRepository repository;

    @Autowired
    private LanguageRepository repositoryLanguage;

    @Override
    public List<FilmEntity> getAll() {
        List<FilmEntity> filmEntities = repository.findByOrderByFilmIdAsc();
        return filmEntities;
    }

    @Override
    public FilmEntity getByFilmId(Integer id) {
        FilmEntity filmEntity = repository.findByFilmId(id);
        return filmEntity;
    }

    @Override
    public List<FilmEntity> getSearch(String title, String description) {
        List<FilmEntity> filmEntities = repository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(title, description);
        return filmEntities;
    }

    @Override
    public FilmEntity postFilm(FilmDto dto) {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setTitle(dto.getTitle());
        filmEntity.setDescription(dto.getDescription());
        filmEntity.setReleaseYear(Year.of(dto.getReleaseYear()));

        LanguageEntity languageEntity = repositoryLanguage.findByLanguageId(dto.getLanguageId());
        filmEntity.setLanguageId(languageEntity);

        filmEntity.setRentalDuration(dto.getRentalDuration());
        filmEntity.setRentalRate(dto.getRentalRate());
        filmEntity.setLength(dto.getLength());
        filmEntity.setReplacementCost(dto.getReplacementCost());
        filmEntity.setRating(Rating.valueOf(dto.getRating()));
        filmEntity.setSpecialFeature(dto.getSpecialFeature());
        Date date = new Date();
        filmEntity.setLastUpdate(date);
		filmEntity.setFullText(dto.getFullText());

        repository.save(filmEntity);
        return filmEntity;
    }

    @Override
    public FilmEntity putFilm(Integer film_id, FilmDto dto) {
        FilmEntity filmEntity = repository.findByFilmId(film_id);
        filmEntity.setTitle(dto.getTitle());
        filmEntity.setDescription(dto.getDescription());
        filmEntity.setReleaseYear(Year.of(dto.getReleaseYear()));

        LanguageEntity languageEntity = repositoryLanguage.findByLanguageId(dto.getLanguageId());
        filmEntity.setLanguageId(languageEntity);

        filmEntity.setRentalDuration(dto.getRentalDuration());
        filmEntity.setRentalRate(dto.getRentalRate());
        filmEntity.setLength(dto.getLength());
        filmEntity.setReplacementCost(dto.getReplacementCost());
        filmEntity.setRating(Rating.valueOf(dto.getRating()));
        filmEntity.setSpecialFeature(dto.getSpecialFeature());
        Date date = new Date();
        filmEntity.setLastUpdate(date);
		filmEntity.setFullText(dto.getFullText());

        repository.save(filmEntity);
        return filmEntity;
    }

    @Override
    public FilmEntity deleteFilm(Integer film_id) {
        FilmEntity filmEntity = repository.findByFilmId(film_id);
        repository.delete(filmEntity);
        return filmEntity;
    }
}

