package com.mariano.recetas.mapper.ingrediente;

import com.mariano.recetas.domain.Ingrediente;
import com.mariano.recetas.dto.ingrediente.IngredienteCreateDto;
import com.mariano.recetas.dto.ingrediente.IngredienteCreatedDto;
import com.mariano.recetas.dto.ingrediente.IngredienteInfoDto;

public interface IngredienteMapper {
	
	Ingrediente ingredienteCreateDtoToIngrediente(IngredienteCreateDto ingredienteDto);
	
	IngredienteCreatedDto ingredienteToIngredienteCreatedDto(Ingrediente ingrediente);
	
	IngredienteInfoDto ingredienteToIngredienteInfoDto(Ingrediente ingrediente);

}
