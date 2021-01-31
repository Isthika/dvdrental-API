package com.testdvdrental.dvdrental.repository;

import com.testdvdrental.dvdrental.entity.ActorEntity;
import com.testdvdrental.dvdrental.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer> {

    LanguageEntity findByLanguageId(Integer language_id);
    List<LanguageEntity> findByName(String name);
    List<LanguageEntity> findByLastUpdate(Date last_update);

}