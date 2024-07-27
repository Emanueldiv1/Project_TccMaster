package com.tccmaster.projectccmaster.aplication.controller;

import com.tccmaster.projectccmaster.aplication.entity.AlunoEntity;
import com.tccmaster.projectccmaster.aplication.entity.CursoEntity;
import com.tccmaster.projectccmaster.aplication.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @ResponseStatus(CREATED)
    public CursoEntity saveCurso(@RequestBody CursoEntity curso){
        return cursoRepository.save(curso);
    }

    @GetMapping("{id}")
    public CursoEntity getCursoById(@PathVariable Long id){
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Curso Não encontrado"));
    }

    @GetMapping
    public List<CursoEntity> listarCursos(CursoEntity filterCursos) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );
        Example example = Example.of(filterCursos, matcher);
        return cursoRepository.findAll(example);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateCurso(@PathVariable long id, @RequestBody CursoEntity curso){
        cursoRepository.findById(id)
                .map(cursoExist -> {
                    curso.setId(cursoExist.getId());
                    cursoRepository.save(curso);
                    return cursoExist;
                }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Curso não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletarCurso(@PathVariable long id){
        cursoRepository.findById(id)
                .map(curso -> {
                    cursoRepository.delete(curso);
                    return curso;
                }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Curso não encontrado"));
    }

}
