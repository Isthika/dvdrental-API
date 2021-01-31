package com.testdvdrental.dvdrental.controller;


import com.testdvdrental.dvdrental.dto.LanguageDto;
import com.testdvdrental.dvdrental.entity.LanguageEntity;
import com.testdvdrental.dvdrental.service.LanguageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class LanguageController {

    @Autowired
    private LanguageServiceImpl service;

    @GetMapping("language")
    public ResponseEntity<?> getAllLanguage(){
        List<LanguageEntity> languageEntities = service.getAllLanguage();
        return ResponseEntity.ok(languageEntities);
    }

    @GetMapping("language/id/{id}")
    public ResponseEntity<?> getByLanguageId(@PathVariable Integer id){
        LanguageEntity languageEntity = service.getbyLanguageId(id);
        return ResponseEntity.ok(languageEntity);
    }

    @GetMapping("language/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){
        List<LanguageEntity> languageEntities = service.getByName(name);
        return ResponseEntity.ok(languageEntities);
    }

    @GetMapping("language/lastUpdate/{lastUpdate")
    public ResponseEntity<?> getByLastUpdate(@PathVariable Date lastUpdate){
        List<LanguageEntity> languageEntities = service.getByLastUpdate(lastUpdate);
        return ResponseEntity.ok(languageEntities);
    }

    @PostMapping("/language")
    public ResponseEntity<?> postLanguage(@RequestBody LanguageDto dto){
        LanguageEntity languageEntity = service.postLanguage(dto);
        return ResponseEntity.ok(languageEntity);
    }

    @PutMapping("/language/id/{id}")
    public ResponseEntity<?> putLanguage(@PathVariable Integer id, @RequestBody LanguageDto dto){
        LanguageEntity languageEntity = service.putLanguage(id, dto);
        return ResponseEntity.ok(languageEntity);
    }

    @DeleteMapping("/language/id/{id}")
    public ResponseEntity<?> deleteLanguage(@PathVariable Integer id){
        LanguageEntity languageEntity = service.deleteLanguage(id);
        return ResponseEntity.ok(languageEntity);
    }

}
