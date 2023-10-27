package com.working.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import com.working.model.Registro;
import com.working.model.Tipo;
import com.working.repository.IRegistroRepository;
import com.working.repository.ITipoRepository;

@Controller
public class ProyectoController {
	@Autowired 
	IRegistroRepository repoRegistro;

	@Autowired 
	ITipoRepository repoTipo;
	//controlador para cargar la pagina
	@GetMapping("/index")
	public String cargarPaginaInicial() {
		return "index";
	}
	
	@GetMapping("/index/HomeAcount/listadoResgistro")
    public String listaReg(Model model) {
        model.addAttribute("listaRegistro", repoRegistro.findAll());
       
		
		model.addAttribute("empresa", new Registro());
		model.addAttribute("boton","Registrar");
        
        return "Registro";
    }
	@GetMapping("/registro/guardar")
	public String RegistrarUsuario(@ModelAttribute Registro registro,Model model ) {
		
		try {
			repoRegistro.save(registro);
			model.addAttribute("boton","Registrar");
		} catch (Exception e) {
			 model.addAttribute("listaRegistro", repoRegistro.findAll());
			model.addAttribute("mensaje","No se pudo registrar");
			model.addAttribute("clase","alert alert-danger");
		}
		return "registro";
	}
	@GetMapping("/listado")
	public String muestraListado(Model model) {
		//enviar un listado para cargar el combo
		//model.addAttribute("mensaje", "exito");
		model.addAttribute("lstProductos",repoTipo.findAll());
		
		model.addAttribute("tipo", new Tipo());
		model.addAttribute("boton","Registrar");
		
		return "registro";
	}
	
	@GetMapping("/index/login")
	public String cargarPaginaLogin() {
		return "login";
	}
	
}

