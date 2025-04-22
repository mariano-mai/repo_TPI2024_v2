package com.mariano.recetas.repository.paso;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariano.recetas.domain.Paso;

public interface PasoRepository extends JpaRepository<Paso, UUID>{

}
