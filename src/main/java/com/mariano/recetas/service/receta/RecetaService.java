package com.mariano.recetas.service.receta;

import java.util.Optional;
import java.util.UUID;

import com.mariano.recetas.dto.receta.RecetaByIdDto;
import com.mariano.recetas.dto.receta.RecetaCreateDto;
import com.mariano.recetas.dto.receta.RecetaCreatedDto;

public interface RecetaService {
	
	Optional<RecetaCreatedDto> createReceta(RecetaCreateDto recetaDto);
	
	Optional<RecetaByIdDto> getRecetaById(UUID id);
	
	boolean deleteReceta(UUID id);

}
