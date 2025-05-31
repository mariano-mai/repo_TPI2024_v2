package com.mariano.recetas.mapper.paso.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mariano.recetas.domain.Ingrediente;
import com.mariano.recetas.domain.Paso;
import com.mariano.recetas.dto.ingrediente.IngredienteCreateDto;
import com.mariano.recetas.dto.ingrediente.IngredienteInfoDto;
import com.mariano.recetas.dto.paso.PasoCreatedV2Dto;
import com.mariano.recetas.dto.paso.PasoCreateDto;
import com.mariano.recetas.dto.paso.PasoCreateV2Dto;
import com.mariano.recetas.dto.paso.PasoCreatedDto;
import com.mariano.recetas.dto.paso.PasoRecetaByIdDto;
import com.mariano.recetas.dto.paso.PasoUpdateDto;
import com.mariano.recetas.dto.paso.PasoUpdatedDto;
import com.mariano.recetas.mapper.ingrediente.IngredienteMapper;
import com.mariano.recetas.mapper.paso.PasoMapper;
import com.mariano.recetas.repository.receta.RecetaRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PasoMapperImpl implements PasoMapper{
	
	private RecetaRepository recetaRepo;
	private IngredienteMapper ingredienteMapper;

	@Override
	public Paso pasoCreateDtoToPaso(PasoCreateDto pasoDto) {
		Paso newPaso = new Paso();
		newPaso.setReceta(recetaRepo.getReferenceById(pasoDto.idReceta()));
		newPaso.setDescripcion(pasoDto.descripcion());
		newPaso.setTiempoEstimado(pasoDto.tiempoEstimado());
		newPaso.setEsNecesario(pasoDto.esNecesario());
		return newPaso;
	}

	@Override
	public PasoCreatedDto pasoToPasoCreatedDto(Paso paso) {
		return new PasoCreatedDto(
				paso.getId(), 
				paso.getDescripcion(), 
				paso.getReceta().getNombre());
	}

	@Override
	public Paso pasoCreateV2DtoToPaso(PasoCreateV2Dto pasoDto) {
		Paso newPaso = new Paso();
		newPaso.setReceta(recetaRepo.getReferenceById(pasoDto.idReceta()));
		newPaso.setDescripcion(pasoDto.descripcion());
		newPaso.setTiempoEstimado(pasoDto.tiempoEstimado());
		newPaso.setEsNecesario(pasoDto.esNecesario());
		newPaso.setIngredientes(listaDeIngredientes(pasoDto.ingredientes()));
		return newPaso;
	}
	
	private List<Ingrediente> listaDeIngredientes(List<IngredienteCreateDto> ingredientesDto){
		List<Ingrediente> newList = new ArrayList<>();
		ingredientesDto.stream()
			.forEach(ingrediente->newList.add(ingredienteMapper.ingredienteCreateDtoToIngrediente(ingrediente)));
		return newList;
	}

	@Override
	public PasoCreatedV2Dto pasoToPasoCreatedV2Dto(Paso paso) {
		return new PasoCreatedV2Dto(
				paso.getId(), 
				paso.getDescripcion(), 
				listaDeIngredientesInfoDto(paso.getIngredientes()));
	}
	
	private List<IngredienteInfoDto> listaDeIngredientesInfoDto(List<Ingrediente> ingredientes){
		List<IngredienteInfoDto> newList = new ArrayList<>();
		ingredientes.stream()
			.forEach(ingrediente->newList.add(ingredienteMapper.ingredienteToIngredienteInfoDto(ingrediente)));
		return newList;
	}

	@Override
	public PasoRecetaByIdDto pasoToPasoRecetaByIdDto(Paso paso) {
		return new PasoRecetaByIdDto(
				paso.getId(), 
				paso.getTiempoEstimado(), 
				listaDeIngredientesInfoDto(paso.getIngredientes()));
	}

	@Override
	public PasoUpdatedDto pasoToPasoUpdatedDto(Paso paso) {
		return new PasoUpdatedDto(
				paso.getDescripcion(), 
				paso.getTiempoEstimado(), 
				paso.isEsNecesario(), 
				listaDeIngredientesInfoDto(paso.getIngredientes()));
	}

	@Override
	public void updatePaso(Paso paso, PasoUpdateDto pasoDto) {
		paso.setDescripcion(pasoDto.descripcion());
		paso.setTiempoEstimado(pasoDto.tiempoEstimado());
		paso.setEsNecesario(pasoDto.esNecesario());
		paso.setIngredientes(listaDeIngredientes(pasoDto.ingredientes()));
	}

}
