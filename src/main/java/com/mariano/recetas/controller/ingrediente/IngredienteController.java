package com.mariano.recetas.controller.ingrediente;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mariano.recetas.dto.ingrediente.IngredienteCreateDto;
import com.mariano.recetas.dto.ingrediente.IngredienteCreatedDto;
import com.mariano.recetas.service.ingrediente.IngredienteService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class IngredienteController {
	
	private IngredienteService ingredienteService;
	
	@PostMapping("/api/v1/ingrediente")
	public ResponseEntity<?> createIngredient(@RequestBody IngredienteCreateDto ingredienteDto){
		Optional<IngredienteCreatedDto> ingredienteCreatedDto = ingredienteService.createIngredient(ingredienteDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ingredienteCreatedDto.get());
	}

}
