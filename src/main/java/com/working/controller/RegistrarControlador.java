package com.working.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.working.model.Registro;
import com.working.repository.IRegistroRepository;


@Controller
public class RegistrarControlador {
	
	@Autowired
	private IRegistroRepository repoRegis;

	@PostMapping("/registro/guardar")
	public String garbarCrudRegistro(@ModelAttribute Registro registro, Model model) {
		
		try {
			repoRegis.save(registro);
			model.addAttribute("mensaje","REGISTRO OK");
			model.addAttribute("clase","alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje","ERROR DE REGISTRO ");
			model.addAttribute("clase","alert alert-danger");
		}
		return "registro";
	}
}
