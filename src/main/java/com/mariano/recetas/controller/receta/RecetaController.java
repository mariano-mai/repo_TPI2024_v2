package com.mariano.recetas.controller.receta;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mariano.recetas.dto.receta.RecetaByIdDto;
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
	
	@GetMapping("/api/v1/receta/{idReceta}")
	public ResponseEntity<RecetaByIdDto> getRecetaById(@PathVariable("idReceta") UUID idReceta){
		Optional<RecetaByIdDto> recetaDto = recetaService.getRecetaById(idReceta);
		if(recetaDto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Receta no encontrada.");
		}
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(recetaDto.get());
	}
	
	@DeleteMapping("/api/v1/receta/{idReceta}")
	public ResponseEntity<?> deleteReceta(@PathVariable("idReceta") UUID idReceta){
		boolean isRecetaDeleted = recetaService.deleteReceta(idReceta);
		if(isRecetaDeleted) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
