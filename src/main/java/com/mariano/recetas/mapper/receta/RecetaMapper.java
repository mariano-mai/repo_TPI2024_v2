package com.mariano.recetas.mapper.receta;

import com.mariano.recetas.domain.Receta;
import com.mariano.recetas.dto.receta.RecetaByCategoriaDto;
import com.mariano.recetas.dto.receta.RecetaByIdDto;
import com.mariano.recetas.dto.receta.RecetaCreateDto;
import com.mariano.recetas.dto.receta.RecetaCreatedDto;

public interface RecetaMapper {
	
	Receta recetaCreateDtoToReceta(RecetaCreateDto recetaDto);
	
	RecetaCreatedDto recetaToRecetaCreatedDto(Receta receta);
	
	RecetaByIdDto recetaToRecetaByIdDto(Receta receta);
	
	RecetaByCategoriaDto recetaToRecetaByCategoriaDto(Receta receta);

}
