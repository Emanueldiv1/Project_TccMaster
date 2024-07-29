package com.tccmaster.projectccmaster.aplication.controller;

import com.tccmaster.projectccmaster.aplication.entity.OrientadorEntity;
import com.tccmaster.projectccmaster.aplication.repository.OrientadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/orientador")
public class OrientadorController {
    @Autowired
    private OrientadorRepository orientadorRepository;


    @PostMapping
    @ResponseStatus(CREATED)
    public OrientadorEntity saveOrientador(@RequestBody OrientadorEntity orientador) {
        return orientadorRepository.save(orientador);
    }

    @GetMapping("{id}")
    public OrientadorEntity getOrientador(@PathVariable UUID id) {
        return orientadorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Orientador não encontrado"));
    }

    @GetMapping
    public List<OrientadorEntity> ListarOrientador(OrientadorEntity filterOrientador) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );
        Example example = Example.of(filterOrientador, matcher);
        return orientadorRepository.findAll(example);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateOrientador(@PathVariable UUID id, @RequestBody OrientadorEntity orientador) {
        orientadorRepository.findById(id)
                .map(orientadorExist -> {
                    orientador.setId(orientadorExist.getId());
                    orientadorRepository.save(orientador);
                    return orientadorExist;
                }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Orientador não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletarOrientador(@PathVariable UUID id){
        orientadorRepository.findById(id)
                .map(orientador -> {
                    orientadorRepository.delete(orientador);
                    return orientador;
                }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Orientador não encontrado"));
    }

}
