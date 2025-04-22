package com.mariano.recetas.controller.paso;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mariano.recetas.dto.paso.PasoCreateDto;
import com.mariano.recetas.dto.paso.PasoCreatedDto;
import com.mariano.recetas.service.paso.PasoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PasoController {
	
	private PasoService pasoService;
	
	@PostMapping("/api/v1/paso")
	public ResponseEntity<?> createPaso(@RequestBody PasoCreateDto pasoDto){
		Optional<PasoCreatedDto> pasoCreated = pasoService.createPaso(pasoDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(pasoCreated.get());
	}

}
