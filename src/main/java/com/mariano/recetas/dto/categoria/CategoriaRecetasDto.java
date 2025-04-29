package com.mariano.recetas.dto.categoria;

import java.util.List;

import com.mariano.recetas.dto.receta.RecetaByCategoriaDto;

public record CategoriaRecetasDto(
		List<RecetaByCategoriaDto> recetas) {}
