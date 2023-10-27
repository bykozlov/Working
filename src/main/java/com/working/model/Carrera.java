package com.working.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="carrera")
@Data
public class Carrera {

	@Id
	private int id_carrera;
	private String nombre;
}
