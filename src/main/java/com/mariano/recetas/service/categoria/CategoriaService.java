package com.mariano.recetas.service.categoria;

import java.util.Optional;
import java.util.UUID;

import com.mariano.recetas.dto.categoria.CategoriaCreateDto;
import com.mariano.recetas.dto.categoria.CategoriaCreatedDto;
import com.mariano.recetas.dto.categoria.CategoriaRecetasDto;

public interface CategoriaService {
	
	Optional<CategoriaCreatedDto> createCategoria(CategoriaCreateDto categoriaDto);
	
	Optional<CategoriaRecetasDto> getCategoriaById(UUID id);

}
