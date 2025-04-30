package com.mariano.recetas.controller.ingrediente;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@GetMapping("/api/v1/ingrediente/{idIngrediente}")
	public ResponseEntity<IngredienteCreatedDto> getIngredienteById(@PathVariable("idIngrediente") Long idIngrediente){
		Optional<IngredienteCreatedDto> ingredienteDto = ingredienteService.getIngredienteById(idIngrediente);
		if(ingredienteDto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingrediente no encontrado.");
		}
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(ingredienteDto.get());
	}

}
