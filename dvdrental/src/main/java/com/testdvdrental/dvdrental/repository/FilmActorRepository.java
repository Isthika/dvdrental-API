package com.testdvdrental.dvdrental.repository;

import com.testdvdrental.dvdrental.entity.ActorEntity;
import com.testdvdrental.dvdrental.entity.FilmActorEntity;
import com.testdvdrental.dvdrental.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActorEntity, Integer>{

    List<FilmActorEntity> findByIdActorId(ActorEntity actor_id);
    List<FilmActorEntity> findByIdFilmId(FilmEntity film_id);

}