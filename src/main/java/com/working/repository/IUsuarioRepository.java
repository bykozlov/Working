package com.working.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.working.model.Usuarios;

public interface IUsuarioRepository extends JpaRepository<Usuarios, Integer>{

	//public Usuarios findByCorreoAn(String usr_usua,String cla_usua);
}
