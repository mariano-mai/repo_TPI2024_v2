package com.mariano.recetas.dto.paso;

import java.util.List;
import java.util.UUID;

import com.mariano.recetas.dto.ingrediente.IngredienteInfoDto;

public record PasoRecetaByIdDto(
		UUID id, 
		Long tiempoEstimado, 
		List<IngredienteInfoDto> ingredientes) {}
