package com.mariano.recetas.controller.paso;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mariano.recetas.dto.paso.PasoCreatedV2Dto;
import com.mariano.recetas.dto.paso.PasoUpdateDto;
import com.mariano.recetas.dto.paso.PasoUpdatedDto;
import com.mariano.recetas.dto.paso.PasoCreateDto;
import com.mariano.recetas.dto.paso.PasoCreateV2Dto;
import com.mariano.recetas.dto.paso.PasoCreatedDto;
import com.mariano.recetas.service.paso.PasoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PasoController {
	
	private PasoService pasoService;
	
	@PostMapping("/api/v1/paso")
	public ResponseEntity<?> createPaso(
			@RequestBody PasoCreateDto pasoDto){
		Optional<PasoCreatedDto> pasoCreated = pasoService.createPaso(pasoDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(pasoCreated.get());
	}
	
	@PostMapping("/api/v2/paso")
	public ResponseEntity<?> createPaso(
			@RequestBody PasoCreateV2Dto pasoDto){
		Optional<PasoCreatedV2Dto> pasoCreated = pasoService.createPaso(pasoDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(pasoCreated.get());
	}
	
	@PutMapping("/api/v1/paso/{idPaso}")
	public ResponseEntity<?> updatePaso(
			@PathVariable("idPaso") UUID idPaso, 
			@RequestBody PasoUpdateDto pasoDto){
		Optional<PasoUpdatedDto> pasoUpdatedDto = pasoService.updatePaso(idPaso, pasoDto);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(pasoUpdatedDto.get());
	}
	

}
