package com.mariano.recetas.repository.ingrediente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariano.recetas.domain.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{

}
