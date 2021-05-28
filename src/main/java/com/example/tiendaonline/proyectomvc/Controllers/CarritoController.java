package com.example.tiendaonline.proyectomvc.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.tiendaonline.proyectomvc.servicios.ServicioDetalleVenta;
import com.example.tiendaonline.proyectomvc.servicios.ServicioProducto;
import com.example.tiendaonline.proyectomvc.servicios.ServicioUsuario;
import com.example.tiendaonline.proyectomvc.servicios.ServicioVenta;
import com.example.tiendaonline.proyectomvc.modelo.Carrito;
import com.example.tiendaonline.proyectomvc.modelo.Detalleventa;
import com.example.tiendaonline.proyectomvc.modelo.Producto;
import com.example.tiendaonline.proyectomvc.modelo.Usuario;
import com.example.tiendaonline.proyectomvc.modelo.Venta;


@Controller
public class CarritoController {

	List<Carrito> MiCarrito=new ArrayList<>();
	
	@Autowired
	ServicioProducto servicioProducto;
	
	@Autowired
	ServicioUsuario servicioUsuario;
	
	@Autowired
	ServicioVenta servicioVenta;
	
	@Autowired
	ServicioDetalleVenta servicioDetalleVenta;
	
	

	@GetMapping("/Carrito/Agregar/{Id}")
	public String AgregarCarrito(@PathVariable int Id,HttpSession sesioncarrito,HttpSession sesion) {
		int CatProdcuto=1;
		int Posicion=0;
		
		Producto producto=servicioProducto.BuscarProducto(Id);
		
		if(MiCarrito.size()>0)
		{
			for (int i=0;i< MiCarrito.size(); i++)
			{
				if (producto.getIdproducto()==MiCarrito.get(i).getIdProducto()) 
				{
					Posicion=i;
				}
			}
			
			if (producto.getIdproducto()==MiCarrito.get(Posicion).getIdProducto()) 
			{
				CatProdcuto=MiCarrito.get(Posicion).getCantidad()+CatProdcuto;
				
				MiCarrito.get(Posicion).setCantidad(CatProdcuto);
			}
			else
			{
				Carrito OCarrito=new Carrito();
				
				OCarrito.setIdProducto(producto.getIdproducto());
				OCarrito.setNombre(producto.getNombre());
				OCarrito.setImagen(producto.getImagen());
				OCarrito.setPrecio(producto.getPrecio());
				OCarrito.setCantidad(CatProdcuto);
				
				MiCarrito.add(OCarrito);
			}
		}
		else
		{
			Carrito OCarrito=new Carrito();
			
			OCarrito.setIdProducto(producto.getIdproducto());
			OCarrito.setNombre(producto.getNombre());
			OCarrito.setImagen(producto.getImagen());
			OCarrito.setPrecio(producto.getPrecio());
			OCarrito.setCantidad(CatProdcuto);
			
			MiCarrito.add(OCarrito);
		}
		
		
		sesioncarrito.setAttribute("CarritoTotalPrecio", MiCarrito.stream().mapToInt(p->p.getSubTotal()).sum());
		sesioncarrito.setAttribute("CarritoTotalProductos", MiCarrito.size());
		
		
		
		return "redirect:/Producto/VerProductos";
	}
	
	@GetMapping("/Carrito/VerProductos")
	public String VerProductosCarrito(Model modelo,HttpSession sesioncarrito,HttpSession sesion) {
		
		if(sesion.getAttribute("nombreusuario")!=null)
		{
			modelo.addAttribute("NombreUsuario",sesion.getAttribute("nombreusuario").toString());
		}
		
		if(sesioncarrito.getAttribute("CarritoTotalProductos")!=null)
		{
			modelo.addAttribute("CarritoTotalProductos",sesioncarrito.getAttribute("CarritoTotalProductos").toString());
			
		}
		
		if(sesioncarrito.getAttribute("CarritoTotalPrecio")!=null)
		{
			modelo.addAttribute("CarritoTotalPrecio",sesioncarrito.getAttribute("CarritoTotalPrecio").toString());
			
		}
		
		if(MiCarrito.size()!=0)
		{
			modelo.addAttribute("CarritoProductos", MiCarrito);
		}
		else
		{
			modelo.addAttribute("error", "No hay productos en el carrito.");
		}
		
		return "Carrito/VerProductos";
	}
	
	@GetMapping("/Carrito/Eliminar/{Id}")
	public String EliminarProductoCarrito(@PathVariable int Id,HttpSession sesioncarrito)
	{
		for (int i=0;i<MiCarrito.size(); i++) 
		{
			if (MiCarrito.get(i).getIdProducto()==Id) 
			{
				MiCarrito.remove(i);
			}
		}
		
		sesioncarrito.setAttribute("CarritoTotalPrecio", MiCarrito.stream().mapToInt(p->p.getSubTotal()).sum());
		sesioncarrito.setAttribute("CarritoTotalProductos", MiCarrito.size());
		
		return "redirect:/Carrito/VerProductos";
	}
	
	@GetMapping("/Venta/Agregar")
	public String AgregarVenta(Model modelo,Venta venta,HttpSession sesion,Venta Oventa,HttpSession sesioncarrito) {

		if(MiCarrito.size()>0)
		{
			int IdUsuario=Integer.parseInt(sesion.getAttribute("idusuario").toString());
			Usuario usuario=servicioUsuario.BuscarUsuario(IdUsuario);
			
			
			
			venta.setUsuario(usuario);
			venta.setCantidadproductos(Integer.parseInt(sesioncarrito.getAttribute("CarritoTotalProductos").toString()));
			venta.setTotal(Integer.parseInt(sesioncarrito.getAttribute("CarritoTotalPrecio").toString()));
			
			if (!servicioVenta.AgregarVenta(venta))
			{
				modelo.addAttribute("error",servicioVenta.getMensaje());
				
				return "Ventas/VerCompras";
			}
			
	       
			for (int i=0;i< MiCarrito.size(); i++)
			{
				Detalleventa detalleVenta=new Detalleventa();
				Producto Oproducto=servicioProducto.BuscarProducto(MiCarrito.get(i).getIdProducto());
			    Oventa=servicioVenta.UltimoRegistroVenta(servicioVenta.IdUltimoRegistroVenta());
				detalleVenta.setProducto(Oproducto);
				detalleVenta.setVenta(Oventa);
				detalleVenta.setPrecio(MiCarrito.get(i).getPrecio());
				detalleVenta.setCantidad(MiCarrito.get(i).getCantidad());
				detalleVenta.setSubtotal(MiCarrito.get(i).getSubTotal());
				servicioDetalleVenta.AgregarDetalleVenta(detalleVenta);
			}
			
			MiCarrito.clear();
			
			sesioncarrito.setAttribute("CarritoTotalPrecio", MiCarrito.stream().mapToInt(p->p.getSubTotal()).sum());
			sesioncarrito.setAttribute("CarritoTotalProductos", MiCarrito.size());
			
			
			
			modelo.addAttribute("error","Compra éxitosa.");
			
			Iterable<Venta> miscompras=servicioVenta.MisCompras(IdUsuario);
			
			if(miscompras!=null && miscompras.iterator().hasNext())
			{
				modelo.addAttribute("miscompras",miscompras);
			}
			else
			{
				modelo.addAttribute("error","Aún no hay compras");
			}
			return "redirect:/Venta/VerCompras";
		}
		
		
		return "redirect:/Carrito/VerProductos";
		
	}
	
	@GetMapping("/Venta/VerCompras")
	public String MisCompras(Model modelo,HttpSession sesion,HttpSession sesioncarrito)
	{
		
		int IdUsuario=Integer.parseInt(sesion.getAttribute("idusuario").toString());
		Iterable<Venta> miscompras=servicioVenta.MisCompras(IdUsuario);
		
		
		if(sesion.getAttribute("nombreusuario")!=null)
		{
			modelo.addAttribute("NombreUsuario",sesion.getAttribute("nombreusuario").toString());
		}
		
		if(sesioncarrito.getAttribute("CarritoTotalProductos")!=null)
		{
			modelo.addAttribute("CarritoTotalProductos",sesioncarrito.getAttribute("CarritoTotalProductos").toString());
			
		}
		
		if(sesioncarrito.getAttribute("CarritoTotalPrecio")!=null)
		{
			modelo.addAttribute("CarritoTotalPrecio",sesioncarrito.getAttribute("CarritoTotalPrecio").toString());
			
		}
		
		if(miscompras!=null && miscompras.iterator().hasNext())
		{
			modelo.addAttribute("miscompras",miscompras);
		}
		else
		{
			modelo.addAttribute("error","Aún no hay compras.");
		}
		return "Ventas/VerCompras";
	}
}
