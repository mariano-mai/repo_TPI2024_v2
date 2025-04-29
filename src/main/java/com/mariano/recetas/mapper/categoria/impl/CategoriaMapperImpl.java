package com.mariano.recetas.mapper.categoria.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mariano.recetas.domain.Categoria;
import com.mariano.recetas.domain.Receta;
import com.mariano.recetas.dto.categoria.CategoriaCreateDto;
import com.mariano.recetas.dto.categoria.CategoriaCreatedDto;
import com.mariano.recetas.dto.categoria.CategoriaRecetasDto;
import com.mariano.recetas.dto.receta.RecetaByCategoriaDto;
import com.mariano.recetas.mapper.categoria.CategoriaMapper;
import com.mariano.recetas.mapper.receta.RecetaMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CategoriaMapperImpl implements CategoriaMapper{
	
	private RecetaMapper recetaMapper;

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

	@Override
	public CategoriaRecetasDto categoriaToCategoriaRecetasDto(Categoria categoria) {
		return new CategoriaRecetasDto(
				listaDeRecetasDto(categoria.getRecetas()));
	}
	
	private List<RecetaByCategoriaDto> listaDeRecetasDto(List<Receta> recetas){
		List<RecetaByCategoriaDto> newList = new ArrayList<>();
		recetas.stream()
			.forEach(receta->newList.add(recetaMapper.recetaToRecetaByCategoriaDto(receta)));
		return newList;
	}

}
