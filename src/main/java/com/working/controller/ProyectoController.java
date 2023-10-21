package com.working.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProyectoController {

	//controlador para cargar la pagina
	@GetMapping("/index")
	public String cargarPaginaInicial() {
		return "index";
	}
	@GetMapping("/index/registro")
	public String cargarPaginaRegistro() {
		return "registro";
	}
	
}
