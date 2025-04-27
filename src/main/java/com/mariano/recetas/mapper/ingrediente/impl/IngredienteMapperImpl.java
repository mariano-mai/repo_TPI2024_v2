package com.mariano.recetas.mapper.ingrediente.impl;

import org.springframework.stereotype.Component;

import com.mariano.recetas.domain.Ingrediente;
import com.mariano.recetas.dto.ingrediente.IngredienteCreateDto;
import com.mariano.recetas.dto.ingrediente.IngredienteCreatedDto;
import com.mariano.recetas.dto.ingrediente.IngredienteInfoDto;
import com.mariano.recetas.mapper.ingrediente.IngredienteMapper;

@Component
public class IngredienteMapperImpl implements IngredienteMapper{

	@Override
	public Ingrediente ingredienteCreateDtoToIngrediente(IngredienteCreateDto ingredienteDto) {
		Ingrediente newIngrediente = new Ingrediente();
		newIngrediente.setNombre(ingredienteDto.nombre());
		newIngrediente.setDescripcion(ingredienteDto.descripcion());
		return newIngrediente;
	}

	@Override
	public IngredienteCreatedDto ingredienteToIngredienteCreatedDto(Ingrediente ingrediente) {
		// TODO Auto-generated method stub
		return new IngredienteCreatedDto(
				ingrediente.getId(), 
				ingrediente.getNombre(), 
				ingrediente.getDescripcion());
	}

	@Override
	public IngredienteInfoDto ingredienteToIngredienteInfoDto(Ingrediente ingrediente) {
		// TODO Auto-generated method stub
		return new IngredienteInfoDto(
				ingrediente.getId(), 
				ingrediente.getNombre());
	}

}
