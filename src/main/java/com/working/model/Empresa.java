package com.working.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="empresa")
@Data
public class Empresa {

	@Id
	private int cod_empresa;
	private int ruc;
	private String razon_social;
	private String descripcion;
	private int id_tipo;
	private int id_trabajo;
	private int cod_usuario;
	private int cod_registro;
	
	@ManyToOne
	@JoinColumn(name ="id_tipo", insertable = false,updatable = false)
	private Tipo objTipo;
	
	@ManyToOne
	@JoinColumn(name ="id_trabajo",insertable = false,updatable = false )
	private Trabajo objTrabajo;
	
	@ManyToOne
	@JoinColumn(name ="cod_usuario",insertable = false,updatable = false )
	private Usuarios objUsuarios;
	
	@ManyToOne
	@JoinColumn(name ="cod_registro",insertable = false,updatable = false )
	private Registro objRegistros;
	

}
