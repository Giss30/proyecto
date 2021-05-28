package com.example.tiendaonline.proyectomvc.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tiendaonline.proyectomvc.modelo.Direccion;
import com.example.tiendaonline.proyectomvc.modelo.Usuario;
import com.example.tiendaonline.proyectomvc.servicios.ServicioDireccion;
import com.example.tiendaonline.proyectomvc.servicios.ServicioUsuario;

@Controller
public class DireccionController {
	
	@Autowired
	ServicioDireccion servicioDireccion;
	
	@Autowired
	ServicioUsuario servicioUsuario;
	
	@GetMapping("/Direccion/VerDirecciones")
	public String MisDirecciones(Model modelo,HttpSession sesion)
	{
		int IdUsuario=Integer.parseInt(sesion.getAttribute("idusuario").toString());
		
		Iterable<Direccion> direccion=servicioDireccion.VerMisDirecciones(IdUsuario);
		
		
		
		if(sesion.getAttribute("nombreusuario")!=null)
		{
			modelo.addAttribute("NombreUsuario",sesion.getAttribute("nombreusuario").toString());
		}
		
		if(sesion.getAttribute("CarritoTotalProductos")!=null)
		{
			modelo.addAttribute("CarritoTotalProductos",sesion.getAttribute("CarritoTotalProductos").toString());
			
		}
		
		if(sesion.getAttribute("CarritoTotalPrecio")!=null)
		{
			modelo.addAttribute("CarritoTotalPrecio",sesion.getAttribute("CarritoTotalPrecio").toString());
			
		}
		
		
		
		if(direccion!=null && direccion.iterator().hasNext())
		{
			modelo.addAttribute("direccion", direccion);
		}
		else
		{
			modelo.addAttribute("error","Aún no hay direcciones.");
		}
		
		
		return "Direccion/Listar";
	}
	
	@GetMapping("/Direccion/Agregar")
	public String Agregar(Model modelo,HttpSession sesion)
	{
		if(sesion.getAttribute("nombreusuario")!=null)
		{
			modelo.addAttribute("NombreUsuario",sesion.getAttribute("nombreusuario").toString());
		}
		
		if(sesion.getAttribute("CarritoTotalProductos")!=null)
		{
			modelo.addAttribute("CarritoTotalProductos",sesion.getAttribute("CarritoTotalProductos").toString());
			
		}
		
		if(sesion.getAttribute("CarritoTotalPrecio")!=null)
		{
			modelo.addAttribute("CarritoTotalPrecio",sesion.getAttribute("CarritoTotalPrecio").toString());
			
		}
		
		
		
		modelo.addAttribute("direccion",new Direccion());
		
		return "Direccion/Agregar";
	}
	
	@PostMapping("/Direccion/Agregar")
	public String Agregar(Model modelo,@ModelAttribute Direccion direccion,HttpSession sesion)
	{
		int IdUsuario=Integer.parseInt(sesion.getAttribute("idusuario").toString());
		modelo.addAttribute("direccion",new Direccion());
		
		Usuario usuario =servicioUsuario.BuscarUsuario(IdUsuario);
		direccion.setUsuario(usuario);
		
		boolean resultado=servicioDireccion.Agregar(direccion);
		
		if(resultado)
		{
			return "redirect:/Direccion/VerDirecciones";
		}
		
		modelo.addAttribute("error",servicioDireccion.getMensaje());
		
		return "Direccion/Agregar";
	}
}
