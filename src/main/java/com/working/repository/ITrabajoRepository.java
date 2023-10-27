package com.working.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.working.model.Trabajo;


public interface ITrabajoRepository extends JpaRepository<Trabajo, Integer>{

	//public Trabajo findfindById_trabajo(Integer id_trabajo);
}
