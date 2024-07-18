package com.tccmaster.projectccmaster.aplication.repository;

import com.tccmaster.projectccmaster.aplication.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlunoRepository extends JpaRepository<AlunoEntity, UUID> {
}
