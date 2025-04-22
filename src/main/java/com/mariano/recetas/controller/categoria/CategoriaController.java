package com.mariano.recetas.controller.categoria;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mariano.recetas.dto.categoria.CategoriaCreateDto;
import com.mariano.recetas.dto.categoria.CategoriaCreatedDto;
import com.mariano.recetas.service.categoria.CategoriaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CategoriaController {
	
	private CategoriaService categoriaService;
	
	@PostMapping("/api/v1/categoria")
	public ResponseEntity<?> createCategoria(@RequestBody CategoriaCreateDto categoriaDto){
		Optional<CategoriaCreatedDto> categoriaCreatedDto = categoriaService.createCategoria(categoriaDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(categoriaCreatedDto.get());
	}

}
