package com.mariano.recetas.mapper.categoria.impl;

import org.springframework.stereotype.Component;

import com.mariano.recetas.domain.Categoria;
import com.mariano.recetas.dto.categoria.CategoriaCreateDto;
import com.mariano.recetas.dto.categoria.CategoriaCreatedDto;
import com.mariano.recetas.mapper.categoria.CategoriaMapper;

@Component
public class CategoriaMapperImpl implements CategoriaMapper{

	@Override
	public Categoria categoriaCreatedDtoToCategoria(CategoriaCreateDto categoriaDto) {
		Categoria newCategoria = new Categoria();
		newCategoria.setNombre(categoriaDto.nombre());
		return newCategoria;
	}

	@Override
	public CategoriaCreatedDto categoriaToCategoriaCreatedDto(Categoria categoria) {
		return new CategoriaCreatedDto(
				categoria.getId(), 
				categoria.getNombre());
	}

}
