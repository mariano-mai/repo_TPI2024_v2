package com.mariano.recetas.mapper.categoria;

import com.mariano.recetas.domain.Categoria;
import com.mariano.recetas.dto.categoria.CategoriaCreateDto;
import com.mariano.recetas.dto.categoria.CategoriaCreatedDto;

public interface CategoriaMapper {
	
	Categoria categoriaCreatedDtoToCategoria(CategoriaCreateDto categoriaDto);
	
	CategoriaCreatedDto categoriaToCategoriaCreatedDto(Categoria categoria);

}
