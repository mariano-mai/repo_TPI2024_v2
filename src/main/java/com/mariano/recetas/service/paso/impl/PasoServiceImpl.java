package com.mariano.recetas.service.paso.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mariano.recetas.domain.Paso;
import com.mariano.recetas.dto.paso.PasoCreatedV2Dto;
import com.mariano.recetas.dto.paso.PasoUpdateDto;
import com.mariano.recetas.dto.paso.PasoUpdatedDto;
import com.mariano.recetas.dto.paso.PasoCreateDto;
import com.mariano.recetas.dto.paso.PasoCreateV2Dto;
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

	@Override
	public Optional<PasoCreatedV2Dto> createPaso(PasoCreateV2Dto pasoDto) {
		Paso newPaso = pasoMapper.pasoCreateV2DtoToPaso(pasoDto);
		return Optional.of(pasoMapper.pasoToPasoCreatedV2Dto(pasoRepo.save(newPaso)));
	}

	@Override
	public Optional<PasoUpdatedDto> updatePaso(UUID id, PasoUpdateDto pasoDto) {
		Optional<Paso> paso = Optional.of(pasoRepo.getReferenceById(id));
		if(paso.isPresent()) {
			var pasoEncontrado = paso.get();
			pasoMapper.updatePaso(pasoEncontrado, pasoDto);
			var pasoUpdated = pasoRepo.save(pasoEncontrado);
			return Optional.of(pasoMapper.pasoToPasoUpdatedDto(pasoUpdated));
		}
		return Optional.empty();
	}

}
