package com.working.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="usuario")
@Data
public class Usuarios {

	@Id
	private int cod_usuario;
	 @NotEmpty
	private String correo;
	@NotEmpty
	private String contraseña;
	@NotNull
	private int id_tipo;
	

	@ManyToOne
	@JoinColumn(name = "id_tipo", insertable = false, updatable = false)
	private Tipo objTipo;
	
}
