package com.mariano.recetas.service.receta;

import java.util.Optional;

import com.mariano.recetas.dto.receta.RecetaCreateDto;
import com.mariano.recetas.dto.receta.RecetaCreatedDto;

public interface RecetaService {
	
	Optional<RecetaCreatedDto> createReceta(RecetaCreateDto recetaDto);

}
