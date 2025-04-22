package com.mariano.recetas.dto.categoria;

import java.util.UUID;

public record CategoriaCreatedDto(
		UUID id, 
		String nombre) {}
