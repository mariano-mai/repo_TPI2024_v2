package com.mariano.recetas.repository.receta;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariano.recetas.domain.Receta;

public interface RecetaRepository extends JpaRepository<Receta, UUID>{

}
