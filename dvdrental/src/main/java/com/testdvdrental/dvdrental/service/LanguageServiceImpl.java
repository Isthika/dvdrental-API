package com.testdvdrental.dvdrental.service;

import com.testdvdrental.dvdrental.dto.LanguageDto;
import com.testdvdrental.dvdrental.entity.LanguageEntity;
import com.testdvdrental.dvdrental.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService{

    @Autowired
    private LanguageRepository repository;


    @Override
    public List<LanguageEntity> getAllLanguage() {
        List<LanguageEntity> languageEntities = repository.findAll();
        return languageEntities;
    }

    @Override
    public LanguageEntity getbyLanguageId(Integer language_id) {
        LanguageEntity languageEntity = repository.findByLanguageId(language_id);
        return languageEntity;
    }

    @Override
    public List<LanguageEntity> getByName(String name) {
        List<LanguageEntity> languageEntities = repository.findByName(name);
        return languageEntities;
    }

    @Override
    public List<LanguageEntity> getByLastUpdate(Date date) {
        List<LanguageEntity> languageEntities = repository.findByLastUpdate(date);
        return languageEntities;
    }

    @Override
    public LanguageEntity postLanguage(LanguageDto dto) {
        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setName(dto.getName());
        Date date = new Date();
        languageEntity.setLastUpdate(date);
        repository.save(languageEntity);
        return languageEntity;
    }

    @Override
    public LanguageEntity putLanguage(Integer language_id, LanguageDto dto) {
        LanguageEntity languageEntity = repository.findByLanguageId(language_id);
        languageEntity.setName(dto.getName());
        repository.save(languageEntity);
        return languageEntity;
    }

    @Override
    public LanguageEntity deleteLanguage(Integer language_id) {
        LanguageEntity languageEntity = repository.findByLanguageId(language_id);
        repository.delete(languageEntity);
        return languageEntity;
    }
}
