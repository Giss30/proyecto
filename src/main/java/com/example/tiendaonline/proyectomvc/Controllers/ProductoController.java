package com.example.tiendaonline.proyectomvc.Controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.tiendaonline.proyectomvc.modelo.Categoria;
import com.example.tiendaonline.proyectomvc.modelo.Producto;
import com.example.tiendaonline.proyectomvc.servicios.ServicioCategoria;
import com.example.tiendaonline.proyectomvc.servicios.ServicioProducto;


@Controller
public class ProductoController {
	
	@Autowired
	ServicioProducto servicioProducto;
	
	@Autowired
	ServicioCategoria servicioCategoria;
	
	@GetMapping("/Producto/Listar")
	public String Listar(Model modelo,HttpSession sesion)
	{
		Iterable<Producto> producto=servicioProducto.Verproductos();
		
		if(producto!=null && producto.iterator().hasNext())
		{
			modelo.addAttribute("producto",producto);
		}
		else
		{
			modelo.addAttribute("error","Aún no hay registros.");
		}
		
		modelo.addAttribute("NombreUsuario",sesion.getAttribute("nombreusuario").toString());
		
		return "Producto/Listar";
	}
	
	@GetMapping(path = {"/Producto/VerProductos","/"})
	public String VerProductos(Model modelo,HttpSession sesion,HttpSession sesioncarrito)
	{
		Iterable<Producto> producto=servicioProducto.Verproductos();
		
		if(producto!=null && producto.iterator().hasNext())
		{
			modelo.addAttribute("producto",producto);
		}
		else
		{
			modelo.addAttribute("error","Aún no hay registros.");
		}
		
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
		
		
		
		return "Producto/VerProductos";
	}
	
	@GetMapping("/Producto/Agregar")
	public String Agregar(Model modelo,HttpSession sesion) 
	{
		modelo.addAttribute("producto", new Producto());
		
        Iterable<Categoria> categoria=servicioCategoria.Vercategoria();
		
		if(categoria!=null && categoria.iterator().hasNext())
		{
			modelo.addAttribute("categoria",categoria);
		}
		else
		{
			modelo.addAttribute("error","No se pudo cargar la categoria");
		}
		
		modelo.addAttribute("NombreUsuario",sesion.getAttribute("nombreusuario").toString());
		
		return "Producto/Agregar";
	}
	
	@PostMapping("/Producto/Agregar")
	public String Agregar(Model modelo, @ModelAttribute Producto producto, @RequestParam("IdCategoria") String Idcategoria,@RequestParam("archivo") MultipartFile imagen )
	{
		if(!imagen.isEmpty())
		{
			Path rutaImagen=Paths.get("src//main//resources//static/imagenes/productos");
			
			String rutaAbsoluta=rutaImagen.toFile().getAbsolutePath();
			
			try 
			{
				byte[] bytesImagen=imagen.getBytes();
				
				Path rutaCompleta=Paths.get(rutaAbsoluta+"//"+imagen.getOriginalFilename());
				
				Files.write(rutaCompleta, bytesImagen);
				
				producto.setImagen(imagen.getOriginalFilename());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		Categoria IdCategoria = servicioCategoria.Buscarategoria(Integer.parseInt(Idcategoria));

		if (IdCategoria == null || IdCategoria.getIdcategoria() == 0) {
			
			modelo.addAttribute("error", servicioCategoria.getMensaje());
			
			return "Producto/Agregar";
		} 
		else 
		{
			producto.setCategoria(IdCategoria);
			if (!servicioProducto.Agregar(producto))
			{
				modelo.addAttribute("error",servicioProducto.getMensaje());
				
				return "Producto/Agregar";
			}
		}

		return "redirect:/Producto/Listar";
	}
	
	@GetMapping("/Producto/Eliminar/{IdProducto}")
	public String Eliminar(@PathVariable int IdProducto,Model modelo)
	{
		Producto producto=servicioProducto.BuscarProducto(IdProducto);
		
		if (!servicioProducto.Eliminar(IdProducto))
		{
			modelo.addAttribute("error",servicioProducto.getMensaje());
			
			return "redirect:/Producto/Listar";
		}
		
		if(producto!=null)
		{
			Path rutaImagen=Paths.get("src//main//resources//static/imagenes/productos");
			
			String rutaAbsoluta=rutaImagen.toFile().getAbsolutePath();
			
			try 
			{
				
				Path rutaCompleta=Paths.get(rutaAbsoluta+"//"+producto.getImagen());
				
				Files.delete(rutaCompleta);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		return "redirect:/Producto/Listar";
	}
}
