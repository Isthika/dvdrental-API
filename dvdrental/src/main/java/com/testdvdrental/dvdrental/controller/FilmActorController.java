package com.testdvdrental.dvdrental.controller;

import com.testdvdrental.dvdrental.entity.FilmActorEntity;
import com.testdvdrental.dvdrental.repository.ActorRepository;
import com.testdvdrental.dvdrental.repository.FilmActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class FilmActorController {

    @Autowired
    FilmActorRepository repository;

    @Autowired
    ActorRepository actorRepository;

    @GetMapping("/filmactor")
    public ResponseEntity<?> getAll() {
        List<FilmActorEntity> filmActorEntity = repository.findAll();
        return ResponseEntity.ok(filmActorEntity);
    }

    @GetMapping("/filmactor/id")
    public ResponseEntity<?> getById() {
        List<FilmActorEntity> filmActorEntity = repository.findByIdActorId(actorRepository.findByActorId(1));
        return ResponseEntity.ok(filmActorEntity);
    }
}

