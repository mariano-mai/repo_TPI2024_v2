package com.mariano.recetas.mapper.paso;

import com.mariano.recetas.domain.Paso;
import com.mariano.recetas.dto.ingrediente.PasoCreatedV2Dto;
import com.mariano.recetas.dto.paso.PasoCreateDto;
import com.mariano.recetas.dto.paso.PasoCreateV2Dto;
import com.mariano.recetas.dto.paso.PasoCreatedDto;
import com.mariano.recetas.dto.paso.PasoRecetaByIdDto;

public interface PasoMapper {
	
	Paso pasoCreateDtoToPaso(PasoCreateDto pasoDto);
	
	PasoCreatedDto pasoToPasoCreatedDto(Paso paso);
	
	Paso pasoCreateV2DtoToPaso(PasoCreateV2Dto pasoDto);
	
	PasoCreatedV2Dto pasoToPasoCreatedV2Dto(Paso paso);
	
	PasoRecetaByIdDto pasoToPasoRecetaByIdDto(Paso paso);

}
