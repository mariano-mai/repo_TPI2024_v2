package com.mariano.recetas.service.categoria.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mariano.recetas.domain.Categoria;
import com.mariano.recetas.dto.categoria.CategoriaCreateDto;
import com.mariano.recetas.dto.categoria.CategoriaCreatedDto;
import com.mariano.recetas.mapper.categoria.CategoriaMapper;
import com.mariano.recetas.repository.categoria.CategoriaRepository;
import com.mariano.recetas.service.categoria.CategoriaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService{
	
	private CategoriaMapper categoriaMapper;
	private CategoriaRepository categoriaRepo;

	@Override
	public Optional<CategoriaCreatedDto> createCategoria(CategoriaCreateDto categoriaDto) {
		Categoria newCategoria = categoriaMapper.categoriaCreatedDtoToCategoria(categoriaDto);
		return Optional.of(categoriaMapper.categoriaToCategoriaCreatedDto(categoriaRepo.save(newCategoria)));
	}

}
