package com.mariano.recetas.dto.paso;

import java.util.UUID;

public record PasoCreatedDto(
		UUID id, 
		String descripcion, 
		String receta) {}
