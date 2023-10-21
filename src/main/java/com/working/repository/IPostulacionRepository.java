package com.working.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.working.model.Postulacion;

public interface IPostulacionRepository extends JpaRepository<Postulacion, Integer>{

}
