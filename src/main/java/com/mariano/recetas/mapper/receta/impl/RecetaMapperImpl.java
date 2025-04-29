package com.mariano.recetas.mapper.receta.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mariano.recetas.domain.Categoria;
import com.mariano.recetas.domain.Paso;
import com.mariano.recetas.domain.Receta;
import com.mariano.recetas.dto.categoria.CategoriaCreatedDto;
import com.mariano.recetas.dto.paso.PasoRecetaByIdDto;
import com.mariano.recetas.dto.receta.RecetaByCategoriaDto;
import com.mariano.recetas.dto.receta.RecetaByIdDto;
import com.mariano.recetas.dto.receta.RecetaCreateDto;
import com.mariano.recetas.dto.receta.RecetaCreatedDto;
import com.mariano.recetas.mapper.paso.PasoMapper;
import com.mariano.recetas.mapper.receta.RecetaMapper;
import com.mariano.recetas.repository.categoria.CategoriaRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RecetaMapperImpl implements RecetaMapper{
	
	private CategoriaRepository categoriaRepo;
	private PasoMapper pasoMapper;

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

	@Override
	public RecetaByIdDto recetaToRecetaByIdDto(Receta receta) {
		return new RecetaByIdDto(
				receta.getId(), 
				receta.getNombre(), 
				receta.getDescripcion(), 
				receta.getDificultad(), 
				addCategoriaDto(receta.getCategoria()), 
				listaDePasoInfoDto(receta.getPasos()));
	}
	
	private CategoriaCreatedDto addCategoriaDto(Categoria categoria) {
		return new CategoriaCreatedDto(
				categoria.getId(), 
				categoria.getNombre());
	}
	
	private List<PasoRecetaByIdDto> listaDePasoInfoDto(List<Paso> pasos){
		List<PasoRecetaByIdDto> newList = new ArrayList<>();
		pasos.stream().forEach(paso->newList.add(pasoMapper.pasoToPasoRecetaByIdDto(paso)));
		return newList;
	}

	@Override
	public RecetaByCategoriaDto recetaToRecetaByCategoriaDto(Receta receta) {
		return new RecetaByCategoriaDto(
				receta.getId(), 
				receta.getNombre(), 
				receta.getDificultad(), 
				receta.getDescripcion(), 
				tiempoNecesario(receta.getPasos()));
	}
	
	private Long tiempoNecesario(List<Paso> pasos) {
		Long tiempo = 0L;
		for(Paso paso : pasos) {
			tiempo = paso.isEsNecesario() ? tiempo+paso.getTiempoEstimado():tiempo+0;
		}
		return tiempo;
	}

}
