package com.mariano.recetas.mapper.paso;

import com.mariano.recetas.domain.Paso;
import com.mariano.recetas.dto.paso.PasoCreatedV2Dto;
import com.mariano.recetas.dto.paso.PasoCreateDto;
import com.mariano.recetas.dto.paso.PasoCreateV2Dto;
import com.mariano.recetas.dto.paso.PasoCreatedDto;
import com.mariano.recetas.dto.paso.PasoRecetaByIdDto;
import com.mariano.recetas.dto.paso.PasoUpdateDto;
import com.mariano.recetas.dto.paso.PasoUpdatedDto;

public interface PasoMapper {
	
	Paso pasoCreateDtoToPaso(PasoCreateDto pasoDto);
	
	PasoCreatedDto pasoToPasoCreatedDto(Paso paso);
	
	Paso pasoCreateV2DtoToPaso(PasoCreateV2Dto pasoDto);
	
	PasoCreatedV2Dto pasoToPasoCreatedV2Dto(Paso paso);
	
	PasoRecetaByIdDto pasoToPasoRecetaByIdDto(Paso paso);
	
	PasoUpdatedDto pasoToPasoUpdatedDto(Paso paso);
	
	void updatePaso(Paso paso, PasoUpdateDto pasoDto);

}
