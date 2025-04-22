package com.mariano.recetas.service.paso.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mariano.recetas.domain.Paso;
import com.mariano.recetas.dto.paso.PasoCreateDto;
import com.mariano.recetas.dto.paso.PasoCreatedDto;
import com.mariano.recetas.mapper.paso.PasoMapper;
import com.mariano.recetas.repository.paso.PasoRepository;
import com.mariano.recetas.service.paso.PasoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PasoServiceImpl implements PasoService{
	
	private PasoMapper pasoMapper;
	private PasoRepository pasoRepo;
	
	@Override
	public Optional<PasoCreatedDto> createPaso(PasoCreateDto pasoDto) {
		Paso newPaso = pasoMapper.pasoCreateDtoToPaso(pasoDto);
		return Optional.of(pasoMapper.pasoToPasoCreatedDto(pasoRepo.save(newPaso)));
	}

}
