package com.tccmaster.projectccmaster.aplication.repository;

import com.tccmaster.projectccmaster.aplication.entity.OrientadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrientadorRepository extends JpaRepository<OrientadorEntity, UUID> {
}
