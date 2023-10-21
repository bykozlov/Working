package com.working.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.working.model.Empresa;

public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {

}
