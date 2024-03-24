package com.a3.una.controller;

import com.a3.una.models.Parametro;
import com.a3.una.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parametros")
public class ParametroController {

    @Autowired
    private ParametroRepository parametroRepository;

    // Método para criar um novo parâmetro
    @PostMapping
    public Parametro create(@RequestBody Parametro parametro) {
        return parametroRepository.save(parametro);
    }

    // Método para buscar todos os parâmetros
    @GetMapping
    public List<Parametro> getAll() {
        return parametroRepository.findAll();
    }

    // Método para buscar um parâmetro por ID
    @GetMapping("/{id}")
    public Parametro getById(@PathVariable Long id) {
        return parametroRepository.findById(id).orElse(null);
    }

    // Método para atualizar um parâmetro
    @PutMapping("/{id}")
    public Parametro update(@PathVariable Long id, @RequestBody Parametro parametro) {
        if (!parametroRepository.existsById(id)) {
            throw new IllegalStateException("Parametro não encontrado com ID: " + id);
        }
        parametro.setIdParametro(id);
        return parametroRepository.save(parametro);
    }

    // Método para excluir um parâmetro
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        parametroRepository.deleteById(id);
    }
}