package com.tccmaster.projectccmaster.aplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "coordenador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoordenadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToMany
    @JoinColumn(name = "id_curso", nullable = true)
    private List<CursoEntity> curso;
}
