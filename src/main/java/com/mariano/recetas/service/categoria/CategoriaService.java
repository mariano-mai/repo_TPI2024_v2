package com.mariano.recetas.service.categoria;

import java.util.Optional;

import com.mariano.recetas.dto.categoria.CategoriaCreateDto;
import com.mariano.recetas.dto.categoria.CategoriaCreatedDto;

public interface CategoriaService {
	
	Optional<CategoriaCreatedDto> createCategoria(CategoriaCreateDto categoriaDto);

}
