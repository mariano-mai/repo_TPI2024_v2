package com.mariano.recetas.service.paso;

import java.util.Optional;
import java.util.UUID;

import com.mariano.recetas.dto.paso.PasoCreatedV2Dto;
import com.mariano.recetas.dto.paso.PasoUpdateDto;
import com.mariano.recetas.dto.paso.PasoUpdatedDto;
import com.mariano.recetas.dto.paso.PasoCreateDto;
import com.mariano.recetas.dto.paso.PasoCreateV2Dto;
import com.mariano.recetas.dto.paso.PasoCreatedDto;

public interface PasoService {
	
	Optional<PasoCreatedDto> createPaso(PasoCreateDto pasoDto);
	
	Optional<PasoCreatedV2Dto> createPaso(PasoCreateV2Dto pasoDto);
	
	Optional<PasoUpdatedDto> updatePaso(UUID id, PasoUpdateDto pasoDto);

}
