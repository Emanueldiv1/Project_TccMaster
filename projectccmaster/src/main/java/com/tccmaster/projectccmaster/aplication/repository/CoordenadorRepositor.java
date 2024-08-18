package com.tccmaster.projectccmaster.aplication.repository;

import com.tccmaster.projectccmaster.aplication.entity.CoordenadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoordenadorRepositor extends JpaRepository<CoordenadorEntity, UUID> {
}
