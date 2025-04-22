package com.mariano.recetas.mapper.paso;

import com.mariano.recetas.domain.Paso;
import com.mariano.recetas.dto.paso.PasoCreateDto;
import com.mariano.recetas.dto.paso.PasoCreatedDto;

public interface PasoMapper {
	
	Paso pasoCreateDtoToPaso(PasoCreateDto pasoDto);
	
	PasoCreatedDto pasoToPasoCreatedDto(Paso paso);

}
