package com.a3.una.controller;

import com.a3.una.models.PainelSolar;
import com.a3.una.repository.PainelSolarRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paineis-solares")
public class PainelSolarController {

    private final PainelSolarRepository repository;

    public PainelSolarController(PainelSolarRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<PainelSolar> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public PainelSolar getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("Painel solar não encontrado"));
    }

    @PostMapping
    public PainelSolar create(@RequestBody PainelSolar painelSolar) {
        return repository.save(painelSolar);
    }



    @PostMapping("/save-list")
    public Iterable<PainelSolar> saveList(@RequestBody Iterable<PainelSolar> paineisSolares) {
        return repository.saveAll(paineisSolares);
    }
    @PutMapping("/{id}")
    public PainelSolar update(@PathVariable Long id, @RequestBody PainelSolar painelSolar) {
        PainelSolar painelSolarExistente = repository.findById(id).orElseThrow(() -> new IllegalStateException("Painel solar não encontrado"));
        painelSolarExistente.setPotencia(painelSolar.getPotencia());
        painelSolarExistente.setModulo(painelSolar.getModulo());
        painelSolarExistente.setMarca(painelSolar.getMarca());
        painelSolarExistente.setEstrutura(painelSolar.getEstrutura());
        painelSolarExistente.setTensao(painelSolar.getTensao());
        painelSolarExistente.setFase(painelSolar.getFase());
        return repository.save(painelSolarExistente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

