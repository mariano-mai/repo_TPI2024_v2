package com.mariano.recetas.repository.categoria;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariano.recetas.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID>{

}
