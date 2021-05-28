package com.example.tiendaonline.proyectomvc.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tiendaonline.proyectomvc.modelo.Rol;
import com.example.tiendaonline.proyectomvc.modelo.Usuario;
import com.example.tiendaonline.proyectomvc.servicios.ServicioRol;
import com.example.tiendaonline.proyectomvc.servicios.ServicioUsuario;



@Controller
public class UsuarioController {
	
	@Autowired
	ServicioUsuario servicioUsuario;
	
	@Autowired
	ServicioRol servicioRol;
	
	@GetMapping("/Usuario/Listar")
	public String VerUsuarios(Model modelo,HttpSession sesion)
	{
		Iterable<Usuario> usuario=servicioUsuario.ListarUsuarios();
		
		if(usuario!=null && usuario.iterator().hasNext())
		{
			modelo.addAttribute("usuario", usuario);
		}
		else
		{
			modelo.addAttribute("error", "No hay usuarios registrados.");
		}
		
		modelo.addAttribute("NombreUsuario",sesion.getAttribute("nombreusuario").toString());
		return "Usuario/Listar";
	}
	
	@GetMapping("/Usuario/Agregar")
	public String Agregar(Model modelo) 
	{
		modelo.addAttribute("usuario", new Usuario());
		return "Usuario/Agregar";
	}
	
	@PostMapping("/Usuario/Agregar")
	public String Agregar(Model modelo, @ModelAttribute Usuario usuario,
			@RequestParam("Contrasena") String Contrasena) {
		
		Rol idRol = servicioRol.BuscarRol(2);

		if (idRol == null || idRol.getIdrol() == 0) {
			
			modelo.addAttribute("error", servicioUsuario.getMensaje());
			
			return "Usuario/Agregar";
		} 
		else 
		{
			usuario.setRol(idRol);
			if (!servicioUsuario.Agregar(usuario,Contrasena))
			{
				modelo.addAttribute("error",servicioUsuario.getMensaje());
				
				return "Usuario/Agregar";
			}
		}

		return "redirect:/Acceso/Login";
	}
}
