package com.testdvdrental.dvdrental.service;

import com.testdvdrental.dvdrental.dto.ActorDto;
import com.testdvdrental.dvdrental.entity.ActorEntity;
import com.testdvdrental.dvdrental.exception.ResourceNotFoundException;
import com.testdvdrental.dvdrental.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository repository;

    @Override
    public List<ActorEntity> getAllActor() {
        List<ActorEntity> actorEntities = repository.findAll();
        return actorEntities;
    }

    @Override
    public ActorEntity getByActorId(Integer actor_id) throws ResourceNotFoundException {
        try {
            ActorEntity actorEntity = repository.findByActorId(actor_id);
            return actorEntity;
        } catch (Exception e) {
            throw new ResourceNotFoundException("Resource With Actor Id : " + actor_id + " Not Found!");
        }
    }

    @Override
    public List<ActorEntity> getByFirstName(String first_name) {
        List<ActorEntity> actorEntities = repository.findByFirstName(first_name);
        return actorEntities;
    }

    @Override
    public List<ActorEntity> getByLastName(String last_name) {
        List<ActorEntity> actorEntities = repository.findByLastName((last_name));
        return actorEntities;
    }

    @Override
    public List<ActorEntity> getByLastUpdate(Date date) {
        List<ActorEntity> actorEntities = repository.findByLastUpdate(date);
        return actorEntities;
    }

    @Override
    public List<ActorEntity> getSearch(String b, String c) {
        List<ActorEntity> actorEntities = repository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(b,c);
        return actorEntities;
    }

    @Override
    public ActorEntity postActor(ActorDto dto) {
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setFirstName(dto.getFirstName());
        actorEntity.setLastName(dto.getLastName());
        Date date = new Date();
        actorEntity.setLastUpdate(date);
        repository.save(actorEntity);
        return actorEntity;
    }

    @Override
    public ActorEntity putActor(Integer actor_id, ActorDto dto) {
        ActorEntity actorEntity = repository.findByActorId(actor_id);
        actorEntity.setFirstName(dto.getFirstName());
        actorEntity.setLastName(dto.getLastName());
        repository.save(actorEntity);
        return actorEntity;
    }

    @Override
    public ActorEntity deleteActor(Integer actor_id) {
        ActorEntity actorEntity = repository.findByActorId(actor_id);
        repository.delete(actorEntity);
        return actorEntity;
    }
}
