package com.mariano.recetas.dto.paso;

import java.util.List;

import com.mariano.recetas.dto.ingrediente.IngredienteInfoDto;

public record PasoUpdatedDto(
		String descripcion, 
		long tiempoEstimado, 
		boolean esNecesario, 
		List<IngredienteInfoDto> ingredientes) {}
