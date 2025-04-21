package com.mariano.recetas.service.ingrediente;

import java.util.Optional;

import com.mariano.recetas.dto.ingrediente.IngredienteCreateDto;
import com.mariano.recetas.dto.ingrediente.IngredienteCreatedDto;

public interface IngredienteService {
	
	Optional<IngredienteCreatedDto> createIngredient(IngredienteCreateDto ingredienteCreateDto);

}
