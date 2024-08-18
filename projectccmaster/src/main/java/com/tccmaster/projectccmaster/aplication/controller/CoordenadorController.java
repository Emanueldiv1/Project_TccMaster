package com.tccmaster.projectccmaster.aplication.controller;

import com.tccmaster.projectccmaster.aplication.entity.CoordenadorEntity;
import com.tccmaster.projectccmaster.aplication.repository.CoordenadorRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/coordenador")
public class CoordenadorController {

    @Autowired
    private CoordenadorRepositor coordenadorRepositor;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CoordenadorEntity saveCoordenador(@RequestBody CoordenadorEntity coordenador){
        return coordenadorRepositor.save(coordenador);
    }

    @GetMapping("{id}")
    public CoordenadorEntity getCoordenador(@PathVariable UUID id){
        return coordenadorRepositor.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coordenador não encontrado"));
    }

    @GetMapping
    public List<CoordenadorEntity> listarCoordenador(CoordenadorEntity filterCoordenador){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );
        Example example = Example.of(filterCoordenador, matcher);
        return coordenadorRepositor.findAll(example);
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoordenador(@PathVariable UUID id, @RequestBody CoordenadorEntity coordenador){
        coordenadorRepositor.findById(id)
               .map(coordenadorExist -> {
                    coordenador.setId(coordenadorExist.getId());
                    coordenadorRepositor.save(coordenador);
                    return coordenadorExist;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coordenador não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoordenador(@PathVariable UUID id){
        coordenadorRepositor.findById(id)
               .map(coordenador -> {
                    coordenadorRepositor.delete(coordenador);
                    return coordenador;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coordenador não encontrado"));
    }
}
