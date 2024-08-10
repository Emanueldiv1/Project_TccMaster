package com.tccmaster.projectccmaster.aplication.dto;

import com.tccmaster.projectccmaster.aplication.entity.AlunoEntity;
import com.tccmaster.projectccmaster.aplication.entity.CursoEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Getter
public class AlunoDTO {

    private UUID id;
    private String nome;
    private CursoEntity curso;

   public AlunoDTO(AlunoEntity alunos) {
        this.id = alunos.getId();
        this.nome =alunos.getNome();
        this.curso = alunos.getCurso();
    }
}
