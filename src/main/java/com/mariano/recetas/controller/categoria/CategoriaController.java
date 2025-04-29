package com.mariano.recetas.controller.categoria;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mariano.recetas.dto.categoria.CategoriaCreateDto;
import com.mariano.recetas.dto.categoria.CategoriaCreatedDto;
import com.mariano.recetas.dto.categoria.CategoriaRecetasDto;
import com.mariano.recetas.service.categoria.CategoriaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CategoriaController {
	
	private CategoriaService categoriaService;
	
	@PostMapping("/api/v1/categoria")
	public ResponseEntity<?> createCategoria(
			@RequestBody CategoriaCreateDto categoriaDto){
		Optional<CategoriaCreatedDto> categoriaCreatedDto = categoriaService.createCategoria(categoriaDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(categoriaCreatedDto.get());
	}
	
	@GetMapping("/api/v1/categoria/{idCategoria}")
	public ResponseEntity<CategoriaRecetasDto> getCategoriaById(
			@PathVariable("idCategoria") UUID idCategoria){
		Optional<CategoriaRecetasDto> categoriaDto = categoriaService.getCategoriaById(idCategoria);
		if(categoriaDto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada.");
		}
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(categoriaDto.get());
	}

}
