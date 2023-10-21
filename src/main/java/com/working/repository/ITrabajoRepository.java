package com.working.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.working.model.Trabajo;


public interface ITrabajoRepository extends JpaRepository<Trabajo, Integer>{

	public Trabajo findByTrabajos(Integer id_trabajo_);
}
