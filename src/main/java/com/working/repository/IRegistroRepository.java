package com.working.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.working.model.Registro;

public interface IRegistroRepository extends JpaRepository<Registro, Integer>{
	
}
