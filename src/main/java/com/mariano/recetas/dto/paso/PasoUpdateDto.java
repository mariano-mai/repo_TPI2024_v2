package com.mariano.recetas.dto.paso;

import java.util.List;

import com.mariano.recetas.dto.ingrediente.IngredienteCreateDto;

public record PasoUpdateDto(
		String descripcion, 
		long tiempoEstimado, 
		boolean esNecesario, 
		List<IngredienteCreateDto> ingredientes) {}
