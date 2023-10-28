package com.working.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@GetMapping("/login")
	public String cargarPaginaLogin() {
		return "login";
	}

	/*@PostMapping("/login")
	public String login(@RequestParam("txtCorreoIn") String correo_usu, @RequestParam("txtPasswordIn") String contra_usu,
			Model model) {
		Registro usuario = repoRegistro.findByCorreo_usu(correo_usu);

		if (usuario != null && usuario.getContra_usu().equals(contra_usu)) {
			return "redirect:/dashboard";
		} else {
			model.addAttribute("error", "Credenciales inválidas. Inténtalo de nuevo.");
			return "login";
		}
	}*/

	@GetMapping("/CarreraTec")
	public String redireccionarACarreraTec() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "CarreraTec";
	}

	@GetMapping("/CarreraUni")
	public String redireccionarACarreraUni() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "CarreraUni";
	}

	@GetMapping("/Carrtc1")
	public String carretec1() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasTecnicas/carrtc1";
	}

	@GetMapping("/Carrtc2")
	public String carretec2() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasTecnicas/carrtc2";
	}

	@GetMapping("/Carrtc3")
	public String carretec3() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasTecnicas/carrtc3";
	}

	@GetMapping("/Carrtc4")
	public String carretec4() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasTecnicas/carrtc4";
	}

	@GetMapping("/Carrtc5")
	public String carretec5() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasTecnicas/carrtc5";
	}

	@GetMapping("/Carrtc6")
	public String carretec6() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasTecnicas/carrtc6";
	}

	@GetMapping("/Carrtc7")
	public String carretec7() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasTecnicas/carrtc7";
	}

	@GetMapping("/Carrtc8")
	public String carretec8() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasTecnicas/carrtc8";
	}

	@GetMapping("/Carrtc9")
	public String carretec9() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasTecnicas/carrtc9";
	}

	@GetMapping("/CarrUn1")
	public String carreuni1() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasUniversitarias/carreUni1";
	}

	@GetMapping("/CarrUn2")
	public String carreuni2() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasUniversitarias/carreUni2";
	}

	@GetMapping("/CarrUn3")
	public String carreuni3() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasUniversitarias/carreUni3";
	}

	@GetMapping("/CarrUn4")
	public String carreuni4() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasUniversitarias/carreUni4";
	}

	@GetMapping("/CarrUn5")
	public String carreuni5() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasUniversitarias/carreUni5";
	}

	@GetMapping("/CarrUn6")
	public String carreuni6() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasUniversitarias/carreUni6";
	}

	@GetMapping("/CarrUn7")
	public String carreuni7() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasUniversitarias/carreUni7";
	}

	@GetMapping("/CarrUn8")
	public String carreuni8() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasUniversitarias/carreUni8";
	}

	@GetMapping("/CarrUn9")
	public String carreuni9() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "/webSite/carrerasUniversitarias/carreUni9";
	}
}
