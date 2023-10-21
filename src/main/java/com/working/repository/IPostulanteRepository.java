package com.working.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.working.model.Postulante;

public interface IPostulanteRepository extends JpaRepository<Postulante, Integer> {

}
