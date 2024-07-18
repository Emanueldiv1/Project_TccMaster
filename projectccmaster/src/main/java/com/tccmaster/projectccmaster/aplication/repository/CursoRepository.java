package com.tccmaster.projectccmaster.aplication.repository;

import com.tccmaster.projectccmaster.aplication.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CursoRepository  extends JpaRepository<CursoEntity, Long> {
}
