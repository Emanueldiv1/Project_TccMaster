package com.tccmaster.projectccmaster.aplication.controller;

import com.tccmaster.projectccmaster.aplication.dto.AlunoDTO;
import com.tccmaster.projectccmaster.aplication.entity.AlunoEntity;
import com.tccmaster.projectccmaster.aplication.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoEntity saveAlunos(@RequestBody AlunoEntity aluno) {
        return alunoRepository.save(aluno);
    }


    @GetMapping("{id}")
    public AlunoEntity getAlunoById(@PathVariable UUID id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @GetMapping
   public List<AlunoDTO> listarTodos(){
        List<AlunoEntity> alunos = alunoRepository.findAll();
        return alunos.stream().map(AlunoDTO::new).toList();
    }



   @GetMapping("/completo")
    public List<AlunoEntity> listarAluno(AlunoEntity filterAlunos) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );
        Example example = Example.of(filterAlunos, matcher);
        return alunoRepository.findAll(example);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAluno(@PathVariable UUID id, @RequestBody AlunoEntity aluno) {
        alunoRepository.findById(id)
                .map(alunoExist -> {
                    aluno.setId(alunoExist.getId());
                    alunoRepository.save(aluno);
                    return alunoExist;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAluno(@PathVariable UUID id) {
        alunoRepository.findById(id)
                .map(aluno -> {
                    alunoRepository.delete(aluno);
                    return aluno;

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado"));
    }

}
