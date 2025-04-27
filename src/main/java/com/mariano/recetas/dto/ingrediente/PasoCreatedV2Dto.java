package com.mariano.recetas.dto.ingrediente;

import java.util.List;
import java.util.UUID;

public record PasoCreatedV2Dto(
		UUID id, 
		String descripcion, 
		List<IngredienteInfoDto> ingredientes) {

}
