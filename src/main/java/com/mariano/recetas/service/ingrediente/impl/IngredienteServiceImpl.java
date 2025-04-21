package com.mariano.recetas.service.ingrediente.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mariano.recetas.domain.Ingrediente;
import com.mariano.recetas.dto.ingrediente.IngredienteCreateDto;
import com.mariano.recetas.dto.ingrediente.IngredienteCreatedDto;
import com.mariano.recetas.mapper.ingrediente.IngredienteMapper;
import com.mariano.recetas.repository.ingrediente.IngredienteRepository;
import com.mariano.recetas.service.ingrediente.IngredienteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IngredienteServiceImpl implements IngredienteService{
	
	private IngredienteMapper ingredienteMapper;
	private IngredienteRepository ingredienteRepo;

	@Override
	public Optional<IngredienteCreatedDto> createIngredient(IngredienteCreateDto ingredienteCreateDto) {
		Ingrediente newIngrediente = ingredienteMapper.ingredienteCreateDtoToIngrediente(ingredienteCreateDto);
		return Optional.of(ingredienteMapper.ingredienteToIngredienteCreatedDto(ingredienteRepo.save(newIngrediente)));
	}

}
