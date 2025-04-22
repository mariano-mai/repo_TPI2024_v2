package com.mariano.recetas.mapper.paso.impl;

import org.springframework.stereotype.Component;

import com.mariano.recetas.domain.Paso;
import com.mariano.recetas.dto.paso.PasoCreateDto;
import com.mariano.recetas.dto.paso.PasoCreatedDto;
import com.mariano.recetas.mapper.paso.PasoMapper;
import com.mariano.recetas.repository.receta.RecetaRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PasoMapperImpl implements PasoMapper{
	
	private RecetaRepository recetaRepo;

	@Override
	public Paso pasoCreateDtoToPaso(PasoCreateDto pasoDto) {
		Paso newPaso = new Paso();
		newPaso.setReceta(recetaRepo.getReferenceById(pasoDto.idReceta()));
		newPaso.setDescripcion(pasoDto.descripcion());
		newPaso.setTiempoEstimado(pasoDto.tiempoEstimado());
		newPaso.setEsNecesario(pasoDto.esNecesario());
		return newPaso;
	}

	@Override
	public PasoCreatedDto pasoToPasoCreatedDto(Paso paso) {
		return new PasoCreatedDto(
				paso.getId(), 
				paso.getDescripcion(), 
				paso.getReceta().getNombre());
	}

}
