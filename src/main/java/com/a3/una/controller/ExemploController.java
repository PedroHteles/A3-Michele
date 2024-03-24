package com.a3.una.controller;


import com.a3.una.models.ExemploEntity;
import com.a3.una.service.ExemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exemplo")
public class ExemploController {

    @Autowired
    private ExemploService exemploService;

    @GetMapping
    public List<ExemploEntity> findAll() {
        return exemploService.findAll();
    }

    @GetMapping("/{id}")
    public ExemploEntity findById(@PathVariable Long id) {
        return exemploService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ExemploEntity> save(@RequestBody ExemploEntity entity) {
        ExemploEntity savedEntity = exemploService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ExemploEntity update(@PathVariable Long id, @RequestBody ExemploEntity entity) {
        return exemploService.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        exemploService.delete(id);
    }
}