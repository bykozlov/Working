package com.working.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.working.model.Registro;
import com.working.model.Tipo;
import com.working.model.Usuarios;
import com.working.repository.IRegistroRepository;
import com.working.repository.ITipoRepository;
import com.working.repository.IUsuarioRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProyectoController {
	@Autowired
	IRegistroRepository repoRegistro;

	@Autowired
	ITipoRepository repoTipo;

	@Autowired
	private IUsuarioRepository repoUsu;

	// controlador para cargar la pagina
	// controlador para cargar la pagina
	@GetMapping("/")
	public String cargarprincipal() {
		return "principal";
	}

	@GetMapping("/index")
	public String cargarPaginaInicial() {
		return "index";
	}

	
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

	

	// login
	@GetMapping("/login")
	public String cargarPaginaLogin(Model model) {
		// Aquí, si lo deseas, puedes agregar el modelo necesario para cargar la página
		// de inicio de sesión.
		model.addAttribute("registro", new Registro());
		return "login";
	}

	@GetMapping("/salir")
	public String salirSesion() {
		return "principal";
	}

	@PostMapping("/login")
	public String acceso(@ModelAttribute Registro registro, Model model, HttpSession session) {
		Registro u = repoRegistro.findByCorreoAndClave(registro.getCorreo(), registro.getClave());

		if (u != null) {
			// Guardar el nombre del usuario en la sesión (o cualquier otro dato que
			// necesites)
			session.setAttribute("codReg", u.getCod_registro());
			session.setAttribute("nombreUsuario", u.getNom_usu());
			session.setAttribute("apellidoUsuario", u.getApe_usu());
			session.setAttribute("telefono", u.getTelefono());
			session.setAttribute("dniUsu", u.getDni());
			session.setAttribute("correoUsu", u.getCorreo());
			session.setAttribute("nomEmpresa", u.getNomEmpresa());
			session.setAttribute("lstTipo", u.getId_tipo()); // Agregamos el tipo de cuenta

			return "index"; // o la página que desees mostrar después del login
		} else {
			model.addAttribute("mensaje", "Usuario o clave incorrecto");
			model.addAttribute("clase", "alert alert-danger");
			return "login";
		}
	}

	@GetMapping("/miperfil")
	public String miPerfil(Model model, HttpSession session) {
		// Obtener el nombre del usuario desde la sesión
		
		String nombreUsuario = (String) session.getAttribute("nombreUsuario");
		String apellidoUsuario = (String) session.getAttribute("apellidoUsuario");
		Integer telefono = (Integer) session.getAttribute("telefono");
		Integer dniUsu = (Integer) session.getAttribute("dniUsu");
		String correoUsu = (String) session.getAttribute("correoUsu");
		String nomEmpresa = (String) session.getAttribute("nomEmpresa");
		// Obtener la información del usuario desde la base de datos (usando el nombre
		// de usuario)
		
		model.addAttribute("nombreUsuario", nombreUsuario);
		model.addAttribute("apellidoUsuario", apellidoUsuario);
		model.addAttribute("telefono", telefono);
		model.addAttribute("dniUsu", dniUsu);
		model.addAttribute("correoUsu", correoUsu);
		model.addAttribute("nomEmpresa", nomEmpresa);
		return "perfilPostulante";
	}
	
	
	



	@GetMapping("/CarreraTec")
	public String redireccionarACarreraTec() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "CarreraTec";
	}

	@GetMapping("/CarreraUnilog")
	public String redireccionarACarreraUni() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "CarreraUnilog";
	}

	@GetMapping("/CarreraTeclog")
	public String redireccionarACarreraTeclog() {
		// Realiza cualquier lógica adicional aquí si es necesario
		return "CarreraTeclog";
	}

	@GetMapping("/CarreraUni")
	public String redireccionarACarreraUnilog() {
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

	@GetMapping("/encuesta") // Define la ruta a la página de encuesta
	public String mostrarEncuesta() {
		return "encuesta"; // Retorna el nombre de la vista
	}

}
