package com.mariano.recetas.dto.receta;

import java.util.List;
import java.util.UUID;

import com.mariano.recetas.dto.categoria.CategoriaCreatedDto;
import com.mariano.recetas.dto.paso.PasoRecetaByIdDto;
import com.mariano.recetas.enumerators.EnumDificultad;

public record RecetaByIdDto(
		UUID id, 
		String nombre, 
		String descripcion, 
		EnumDificultad dificultad, 
		CategoriaCreatedDto categoria, 
		List<PasoRecetaByIdDto> pasos) {}
