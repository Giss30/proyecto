package com.proyectoc4.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectoc4.servicios.ServicioAcceso;

@Controller
public class AccesoController {

	@Autowired
	ServicioAcceso servicioAcceso;
	
	@GetMapping("/Acceso/Login")
	public String Login()
	{
		return "Acceso/Login";
	}
	
	@PostMapping("/Acceso/Login")
	public String Login(@RequestParam("username") String correoe,@RequestParam("password") String clave, Model modelo, HttpSession sesion)
	{
		//Usuario usuario=servicioAcceso.ValidarUsuario(Correo, Contrasena);
		//if(usuario!=null)
		//{
			
			
			int TipoUsuario=Integer.parseInt(sesion.getAttribute("tipousuario").toString());
			if(TipoUsuario==1)
			{
				return "redirect:/Categoria/Listar";
			}
			else
			{
				return "redirect:/Producto/VerProductos";
			}
		//}
		
		//modelo.addAttribute("error",servicioAcceso.getMensaje());
		//modelo.addAttribute("Correo",Correo);
		//modelo.addAttribute("Contrasena",Contrasena);
		
		//return "redirect:/Acceso/TipoUsuario";
	}
	
	@PostMapping("/Acceso/TipoUsuario")
	public String ValidarUsuario(HttpSession sesion)
	{

			int TipoUsuario=Integer.parseInt(sesion.getAttribute("tipousuario").toString());
			if(TipoUsuario==1)
			{
				return "redirect:/Categoria/Listar";
			}
			else
			{
				return "redirect:/Producto/VerProductos";
			}

	}
	
	
	@GetMapping("/Acceso/Salir")
	public String Salir(HttpSession sesion)
	{
		SecurityContextHolder.clearContext();
		sesion.invalidate();
		
		return "redirect:/";
	}
}
