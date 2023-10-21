package com.working.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_trabajo")
@Data
public class Trabajo {

	@Id
	private int id_trabajo;
	private String titulo;
	private String descripcion_trabajo;
	private double sueldo;
	private String modalidad;
	private int id_carrera;
	private int id_tipo;
	
	@ManyToOne
	@JoinColumn(name ="id_tipo", insertable = false,updatable = false)
	private Tipo objTipo;
	
	@ManyToOne
	@JoinColumn(name ="id_carrera",insertable = false,updatable = false )
	private Carrera objCarrera;
}
