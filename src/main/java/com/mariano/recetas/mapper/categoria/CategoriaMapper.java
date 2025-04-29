package com.mariano.recetas.mapper.categoria;

import com.mariano.recetas.domain.Categoria;
import com.mariano.recetas.dto.categoria.CategoriaCreateDto;
import com.mariano.recetas.dto.categoria.CategoriaCreatedDto;
import com.mariano.recetas.dto.categoria.CategoriaRecetasDto;

public interface CategoriaMapper {
	
	Categoria categoriaCreatedDtoToCategoria(CategoriaCreateDto categoriaDto);
	
	CategoriaCreatedDto categoriaToCategoriaCreatedDto(Categoria categoria);
	
	CategoriaRecetasDto categoriaToCategoriaRecetasDto(Categoria categoria);

}
