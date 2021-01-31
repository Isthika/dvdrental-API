package com.testdvdrental.dvdrental.service;

import com.testdvdrental.dvdrental.dto.LanguageDto;
import com.testdvdrental.dvdrental.entity.LanguageEntity;

import java.util.Date;
import java.util.List;

public interface LanguageService {

    public List<LanguageEntity> getAllLanguage();
    public LanguageEntity getbyLanguageId(Integer language_id);
    public List<LanguageEntity> getByName(String name);
    public List<LanguageEntity> getByLastUpdate(Date date);

    public LanguageEntity postLanguage(LanguageDto dto);
    public LanguageEntity putLanguage(Integer language_id, LanguageDto dto);
    public LanguageEntity deleteLanguage(Integer language_id);

}
