package com.mariano.recetas.service.paso;

import java.util.Optional;

import com.mariano.recetas.dto.ingrediente.PasoCreatedV2Dto;
import com.mariano.recetas.dto.paso.PasoCreateDto;
import com.mariano.recetas.dto.paso.PasoCreateV2Dto;
import com.mariano.recetas.dto.paso.PasoCreatedDto;

public interface PasoService {
	
	Optional<PasoCreatedDto> createPaso(PasoCreateDto pasoDto);
	
	Optional<PasoCreatedV2Dto> createPaso(PasoCreateV2Dto pasoDto);

}
