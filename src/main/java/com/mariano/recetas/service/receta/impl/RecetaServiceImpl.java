package com.mariano.recetas.service.receta.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mariano.recetas.domain.Receta;
import com.mariano.recetas.dto.receta.RecetaByIdDto;
import com.mariano.recetas.dto.receta.RecetaCreateDto;
import com.mariano.recetas.dto.receta.RecetaCreatedDto;
import com.mariano.recetas.mapper.receta.RecetaMapper;
import com.mariano.recetas.repository.receta.RecetaRepository;
import com.mariano.recetas.service.receta.RecetaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecetaServiceImpl implements RecetaService{
	
	private RecetaMapper recetaMapper;
	private RecetaRepository recetaRepo;
	
	@Override
	public Optional<RecetaCreatedDto> createReceta(RecetaCreateDto recetaDto) {
		Receta newReceta = recetaMapper.recetaCreateDtoToReceta(recetaDto);
		return Optional.of(recetaMapper.recetaToRecetaCreatedDto(recetaRepo.save(newReceta)));
	}

	@Override
	public Optional<RecetaByIdDto> getRecetaById(UUID id) {
		Receta newReceta = recetaRepo.getReferenceById(id);
		return Optional.of(recetaMapper.recetaToRecetaByIdDto(newReceta));
	}

	@Override
	public boolean deleteReceta(UUID id) {
		Optional<Receta> receta = recetaRepo.findById(id);
		if(receta.isPresent()) {
			recetaRepo.delete(receta.get());
			return true;
		}
		return false;
	}

}
