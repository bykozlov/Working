package com.working.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_postulante")
@Data
public class Postulante {

    @Id
    private int id_postulante;
    private String nombre_pos;
    private String apellido_pos;
    private String CV_postulante;
    private int cod_usuario;

    @ManyToOne
    @JoinColumn(name = "cod_usuario", insertable = false, updatable = false)
    private Usuarios objUsuarios;
}