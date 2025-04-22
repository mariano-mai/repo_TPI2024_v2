package com.mariano.recetas.service.paso;

import java.util.Optional;

import com.mariano.recetas.dto.paso.PasoCreateDto;
import com.mariano.recetas.dto.paso.PasoCreatedDto;

public interface PasoService {
	
	Optional<PasoCreatedDto> createPaso(PasoCreateDto pasoDto);

}
