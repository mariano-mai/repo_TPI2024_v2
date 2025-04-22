package com.mariano.recetas.dto.paso;

import java.util.UUID;

public record PasoCreateDto(
		String descripcion, 
		Long tiempoEstimado, 
		boolean esNecesario, 
		UUID idReceta) {}
