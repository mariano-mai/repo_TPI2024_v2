package com.mariano.recetas.dto.receta;

import java.util.UUID;

public record RecetaCreatedDto(
		UUID id, 
		String nombre, 
		String categoria) {}
