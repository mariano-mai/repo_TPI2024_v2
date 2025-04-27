package com.mariano.recetas.dto.paso;

import java.util.List;
import java.util.UUID;

import com.mariano.recetas.dto.ingrediente.IngredienteCreateDto;

public record PasoCreateV2Dto(
		String descripcion, 
		Long tiempoEstimado, 
		List<IngredienteCreateDto> ingredientes, 
		boolean esNecesario, 
		UUID idReceta) {

}
