package com.mariano.recetas.domain;

import java.util.List;
import java.util.UUID;

import com.mariano.recetas.enumerators.EnumDificultad;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Receta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String nombre;
	
	@OneToMany(mappedBy = "receta")
	private List<Paso> pasos;
	
	@Enumerated(EnumType.STRING)
	private EnumDificultad dificultad;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "receta_id")
	private Categoria categoria;

}
