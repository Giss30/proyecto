package com.proyectoc4.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.proyectoc4.modelo.Detalleventa;
import com.proyectoc4.servicios.ServicioDetalleVenta;

@Controller
public class DetalleVentaController {

	@Autowired
	ServicioDetalleVenta servicioDetalleVenta;
	
	@GetMapping("/DetalleVenta/Listar/{IdVenta}")
	public String DetalleVentaUsuario(@PathVariable int IdVenta,HttpSession sesioncarrito,Model modelo, HttpSession sesion) {
		
        Iterable<Detalleventa> detalleventa=servicioDetalleVenta.ListaDetalleVenta(IdVenta);
		
		if(detalleventa!=null && detalleventa.iterator().hasNext())
		{
			modelo.addAttribute("detalleventa", detalleventa);
		}
		else
		{
			modelo.addAttribute("error", "Aún no hay ventas generadas.");
		}
		
		
		if(sesioncarrito.getAttribute("CarritoTotalProductos")!=null)
		{
			modelo.addAttribute("CarritoTotalProductos",sesioncarrito.getAttribute("CarritoTotalProductos").toString());
			
		}
		
		if(sesioncarrito.getAttribute("CarritoTotalPrecio")!=null)
		{
			modelo.addAttribute("CarritoTotalPrecio",sesioncarrito.getAttribute("CarritoTotalPrecio").toString());
			
		}
		
		modelo.addAttribute("NombreUsuario",sesion.getAttribute("nombreusuario").toString());
		
		return "DetalleVenta/Listar";
	}
	
	@GetMapping("/DetalleVenta/MisVentas/{IdVenta}")
	public String DetalleVentaAdmin(@PathVariable int IdVenta,Model modelo, HttpSession sesion) {
		
        Iterable<Detalleventa> detalleventa=servicioDetalleVenta.ListaDetalleVenta(IdVenta);
		
		if(detalleventa!=null && detalleventa.iterator().hasNext())
		{
			modelo.addAttribute("detalleventa", detalleventa);
		}
		else
		{
			modelo.addAttribute("error", "Aún no hay ventas generadas.");
		}
		
		
		modelo.addAttribute("NombreUsuario",sesion.getAttribute("nombreusuario").toString());
		
		return "DetalleVenta/VerDetalleVenta";
	}
}
