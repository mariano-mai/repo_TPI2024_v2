package com.mariano.recetas.controller.receta;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mariano.recetas.dto.receta.RecetaCreateDto;
import com.mariano.recetas.dto.receta.RecetaCreatedDto;
import com.mariano.recetas.service.receta.RecetaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RecetaController {
	
	private RecetaService recetaService;
	
	@PostMapping("/api/v1/receta")
	public ResponseEntity<?> createReceta(@RequestBody RecetaCreateDto recetaDto){
		Optional<RecetaCreatedDto> recetaCreated = recetaService.createReceta(recetaDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(recetaCreated.get());
	}

}
