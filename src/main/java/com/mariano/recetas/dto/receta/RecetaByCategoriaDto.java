package com.mariano.recetas.dto.receta;

import java.util.UUID;

import com.mariano.recetas.enumerators.EnumDificultad;

public record RecetaByCategoriaDto(
		UUID id, 
		String nombre, 
		EnumDificultad dificultad, 
		String descripcion, 
		Long tiempoTotalEstimado) {}
