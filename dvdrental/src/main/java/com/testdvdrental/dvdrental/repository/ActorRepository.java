package com.testdvdrental.dvdrental.repository;

import com.testdvdrental.dvdrental.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ActorRepository extends JpaRepository<ActorEntity, Integer> {

ActorEntity findByActorId(Integer actor_id);
List<ActorEntity> findByFirstName(String first_name);
List<ActorEntity> findByLastName(String last_name);
List<ActorEntity> findByLastUpdate(Date last_update);
    List<ActorEntity> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String b, String c);
}
