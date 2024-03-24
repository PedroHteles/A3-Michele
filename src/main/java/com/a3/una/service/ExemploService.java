package com.a3.una.service;

import com.a3.una.models.ExemploEntity;
import com.a3.una.repository.ExemploRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ExemploService {
    // Injeção de dependência do repositório
    @Autowired
    private ExemploRepository exemploRepository;

    public List<ExemploEntity> findAll() {
        return exemploRepository.findAll();
    }

    public ExemploEntity findById(Long id) {
        return exemploRepository.findById(id).orElse(null);
    }

    public ExemploEntity save(ExemploEntity entity) {
        return exemploRepository.save(entity);
    }

    public ExemploEntity update(Long id, ExemploEntity entity) {
        if (exemploRepository.existsById(id)) {
            entity.setId(id);
            return exemploRepository.save(entity);
        }
        return null;
    }

    public void delete(Long id) {
        exemploRepository.deleteById(id);
    }
}
