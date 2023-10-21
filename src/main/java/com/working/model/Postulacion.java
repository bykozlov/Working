package com.working.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_postulacion")
@Data
public class Postulacion {

	@Id
	private int id_postulacion;
	private int id_postulante;
	private int id_trabajo;
	
	@ManyToMany
	@JoinColumn(name ="id_postulante", insertable = false,updatable = false)
	private Postulante objPostulante;
	
	@ManyToMany
	@JoinColumn(name ="id_trabajo", insertable = false,updatable = false)
	private Trabajo objTrabajo;
}
