package com.working.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="postulacion")
@Data
public class Postulacion {

	@Id
	private int id_postulacion;
	private int id_postulante;
	private int id_trabajo;
	
	@ManyToOne
	@JoinColumn(name ="id_postulante", insertable = false,updatable = false)
	private Postulante objPostulante;
	
	@ManyToOne
	@JoinColumn(name ="id_trabajo", insertable = false,updatable = false)
	private Trabajo objTrabajo;
}
