package com.testdvdrental.dvdrental.service;

import com.testdvdrental.dvdrental.dto.ActorDto;
import com.testdvdrental.dvdrental.entity.ActorEntity;

import java.util.Date;
import java.util.List;


public interface ActorService {

    public List<ActorEntity> getAllActor();
    public ActorEntity getByActorId(Integer actor_id);
    public List<ActorEntity> getByFirstName(String first_name);
    public List<ActorEntity> getByLastName(String last_name);
    public List<ActorEntity> getByLastUpdate(Date date);
    public List<ActorEntity> getSearch(String b, String c);

    public  ActorEntity postActor(ActorDto dto);
    public ActorEntity putActor(Integer actor_id, ActorDto dto);
    public ActorEntity deleteActor(Integer actor_id);
}
