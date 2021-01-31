package com.testdvdrental.dvdrental.controller;

import com.testdvdrental.dvdrental.dto.FilmDto;
import com.testdvdrental.dvdrental.entity.FilmActorEntity;
import com.testdvdrental.dvdrental.entity.FilmEntity;
import com.testdvdrental.dvdrental.exception.APIException;
import com.testdvdrental.dvdrental.exception.ResourceNotFoundException;
import com.testdvdrental.dvdrental.repository.FilmActorRepository;
import com.testdvdrental.dvdrental.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class FilmController {

    @Autowired
    private FilmServiceImpl service;

    @Autowired
    private FilmActorRepository repositoryFilmActor;


    @GetMapping("/film")
    public ResponseEntity<?> getAll() throws APIException {
        List<FilmEntity> filmEntities = service.getAll();
        if(filmEntities.size() > 0) {
            return ResponseEntity.ok(filmEntities);
        }else {
            throw new APIException ("Sorry! Cannot Get Resource");
        }

    }

        @GetMapping("/film/id/{id}")
        public ResponseEntity<?> getById(@PathVariable Integer id)throws ResourceNotFoundException {
            FilmEntity filmEntities = service.getByFilmId(id);
            if(filmEntities != null) {
                return ResponseEntity.ok(filmEntities);
            }else {
                throw new ResourceNotFoundException("Resource With Film Id : " + id + " Not Found!");
            }
        }

        @GetMapping("/film/search/{search}")
        public ResponseEntity<?> getSearch(@PathVariable String search)throws ResourceNotFoundException{
            List<FilmEntity> filmEntities = service.getSearch(search, search);
            if(filmEntities.size() > 0) {
                return ResponseEntity.ok(filmEntities);
            }else {
                throw new ResourceNotFoundException("Resource With : " + search + " Not Found!");
            }
        }

        @PostMapping("/film")
        public ResponseEntity<?> postFilm(@RequestBody FilmDto dto)throws APIException{
            if(dto.getTitle().equals("")) {
                throw new APIException("Title cannot be empty");
            }else if(dto.getDescription().equals("")) {
                throw new APIException("Description cannot be empty");
            }
            else if(dto.getLanguageId().equals("")) {
                throw new APIException("Language cannot be empty");
            }
            else if(dto.getReleaseYear().equals("")) {
                throw new APIException("Release Year cannot be empty");
            }
            else if(dto.getRating().equals("")) {
                throw new APIException("Rating cannot be empty");
            }
            else if(dto.getSpecialFeature().length < 0) {
                throw new APIException("Rating cannot be empty");
            }else {
                FilmEntity filmEntity = service.postFilm(dto);
                if(filmEntity != null) {
                    return ResponseEntity.ok(filmEntity);
                }else {
                    throw new APIException("Sorry! Cannot Insert Data");
                }
            }

        }

        @PutMapping("/film/{film_id}")
        public ResponseEntity<?> putFilm(@PathVariable Integer film_id, @RequestBody FilmDto dto)throws ResourceNotFoundException{
            FilmEntity filmEntities = service.getByFilmId(film_id);
            if(filmEntities != null) {
                if(dto.getTitle().equals("")) {
                    throw new APIException("Title cannot be empty");
                }else if(dto.getDescription().equals("")) {
                    throw new APIException("Description cannot be empty");
                }
                else if(dto.getLanguageId().equals("")) {
                    throw new APIException("Language cannot be empty");
                }
                else if(dto.getReleaseYear().equals("")) {
                    throw new APIException("Release Year cannot be empty");
                }
                else if(dto.getRating().equals("")) {
                    throw new APIException("Rating cannot be empty");
                }
                else if(dto.getSpecialFeature().length < 0) {
                    throw new APIException("Rating cannot be empty");
                }else {
                    FilmEntity filmEntity = service.putFilm(film_id, dto);
                    if(filmEntity != null) {
                        return ResponseEntity.ok(filmEntity);
                    }else {
                        throw new APIException("Sorry! Cannot Insert Data");
                    }
                }
            }else {
                throw new ResourceNotFoundException("Resource With Film Id : " + film_id + " Not Found!");
            }
        }

        @DeleteMapping("/film/{film_id}")
        public ResponseEntity<?> deleteFilm(@PathVariable Integer film_id)throws ResourceNotFoundException {
            FilmEntity filmEntities = service.getByFilmId(film_id);
            if (filmEntities != null) {
                List<FilmActorEntity> filmActorEntity = repositoryFilmActor.findByIdFilmId(filmEntities);
                if (filmActorEntity.size() > 0) {
                    throw new ResourceNotFoundException("Resource With Actor Id : " + film_id + " Found in Other Tabel Relation");
                } else {
                    FilmEntity filmEntity = service.deleteFilm(film_id);
                    return ResponseEntity.ok(filmEntity);
                }
            } else {
                throw new ResourceNotFoundException("Resource With Film Id : " + film_id + " Not Found!");
            }
        }
}
