package com.mariano.recetas.dto.receta;

import java.util.UUID;

import com.mariano.recetas.enumerators.EnumDificultad;

public record RecetaCreateDto(
		String nombre, 
		EnumDificultad dificultad, 
		String descripcion, 
		UUID idCategoria) {}
