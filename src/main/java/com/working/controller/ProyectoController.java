package com.working.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.working.model.Registro;
import com.working.model.Tipo;
import com.working.repository.IRegistroRepository;
import com.working.repository.ITipoRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProyectoController {
	@Autowired
	IRegistroRepository repoRegistro;

	@Autowired
	ITipoRepository repoTipo;

	// controlador para cargar la pagina
	@GetMapping("/index")
	public String cargarPaginaInicial() {
		return "index";
	}

	/*
	 * @GetMapping("/index/HomeAcount/listadoResgistro") public String
	 * listaReg(Model model) { model.addAttribute("listaRegistro",
	 * repoRegistro.findAll());
	 * 
	 * 
	 * model.addAttribute("empresa", new Registro());
	 * model.addAttribute("boton","Registrar");
	 * 
	 * return "Registro"; }
	 */
	 @GetMapping("/registro")
	    public String abrirPagProd(Model model) {
	        // Cargar la lista de tipos y establecerla en el modelo
	        List<Tipo> lstTipo = repoTipo.findAll();
	        model.addAttribute("lstTipo", lstTipo);

	        // Objeto de tipo Registro para guardar los datos
	        model.addAttribute("registro", new Registro());
	        model.addAttribute("boton", "Registrar");
	        return "registro";
	    }

	@PostMapping("/registrar")
	public String RegistrarUsuario(@ModelAttribute("registro") Registro registro, Model model) {
		try {
			repoRegistro.save(registro);
			model.addAttribute("mensaje", "Usuario registrado con éxito");
			model.addAttribute("clase", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "No se pudo registrar");
			model.addAttribute("clase", "alert alert-danger");
		}
		return "registro";
	}

	@GetMapping("/listado")
	public String muestraListado(Model model) {
		// enviar un listado para cargar el combo
		// model.addAttribute("mensaje", "exito");
		model.addAttribute("lstTipo", repoTipo.findAll());

		model.addAttribute("tipo", new Tipo());
		model.addAttribute("boton", "Registrar");

		return "registro";
	}

	@GetMapping("/index/login")
	public String cargarPaginaLogin() {
		return "login";
	}
	 
	@GetMapping("/login")
    public String cargarPaginaIndex() {
        return "login";
    }
}
