package com.working.model;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_usuario")
@Data
public class Usuarios {

	@Id
	private int cod_usuario;

	private String contraseña;
	
	private String correo;
	
	private int id_tipo;
	

	@ManyToOne
	@JoinColumn(name = "id_tipo", insertable = false, updatable = false)
	private Tipo objTipo;
	
}
