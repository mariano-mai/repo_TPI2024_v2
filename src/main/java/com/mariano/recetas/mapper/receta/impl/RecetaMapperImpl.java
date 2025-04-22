package com.mariano.recetas.mapper.receta.impl;

import org.springframework.stereotype.Component;

import com.mariano.recetas.domain.Receta;
import com.mariano.recetas.dto.receta.RecetaCreateDto;
import com.mariano.recetas.dto.receta.RecetaCreatedDto;
import com.mariano.recetas.mapper.receta.RecetaMapper;
import com.mariano.recetas.repository.categoria.CategoriaRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RecetaMapperImpl implements RecetaMapper{
	
	private CategoriaRepository categoriaRepo;

	@Override
	public Receta recetaCreateDtoToReceta(RecetaCreateDto recetaDto) {
		Receta newReceta = new Receta();
		newReceta.setNombre(recetaDto.nombre());
		newReceta.setDificultad(recetaDto.dificultad());
		newReceta.setDescripcion(recetaDto.descripcion());
		newReceta.setCategoria(categoriaRepo.getReferenceById(recetaDto.idCategoria()));
		return newReceta;
	}

	@Override
	public RecetaCreatedDto recetaToRecetaCreatedDto(Receta receta) {
		return new RecetaCreatedDto(
				receta.getId(), 
				receta.getNombre(), 
				receta.getCategoria().getNombre());
	}

}
