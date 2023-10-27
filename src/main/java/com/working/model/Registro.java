package com.working.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="registro")
@Data
public class Registro {

	@Id
	private int cod_registro;
	private String nom_usu;
	private String ape_usu;
	private int telefono;
	private int dni;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_nacimiento;
	private String correo_usu;
	private String contra_usu;
	private int id_tipo;
	
	
	@ManyToOne
	@JoinColumn(name ="id_tipo", insertable = false,updatable = false)
	private Tipo objTipo;
}
