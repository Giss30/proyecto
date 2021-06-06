package com.proyectoc4.Controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.NewFieldTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyectoc4.modelo.Categoria;
import com.proyectoc4.servicios.ServicioCategoria;
import com.proyectoc4.servicios.ServicioImagen;


@Controller
public class CategoriaController {

	@Autowired
	ServicioCategoria servicioCategoria;
	
	@Autowired
	ServicioImagen servicioImagen;
	
	@GetMapping("/Categoria/Listar")
	public String Listar(Model modelo,HttpSession sesion)
	{
		Iterable<Categoria> categoria=servicioCategoria.Vercategoria();
		
		if(categoria!=null && categoria.iterator().hasNext())
		{
			modelo.addAttribute("categoria",categoria);
		}
		else
		{
			modelo.addAttribute("error","Aún no hay registros.");
		}
		
		modelo.addAttribute("NombreUsuario",sesion.getAttribute("nombreusuario").toString());
		
		return "Categoria/Listar";
	}
	
	@GetMapping("/Categoria/Agregar")
	public String Agregar(Model modelo,HttpSession sesion)
	{
		modelo.addAttribute("categoria", new Categoria());
		
		modelo.addAttribute("NombreUsuario",sesion.getAttribute("nombreusuario").toString());
		
		return "Categoria/Agregar";
	}
	
	@PostMapping("/Categoria/Agregar")
	public String Agregar(Model modelo,@ModelAttribute Categoria categoria, @RequestParam("archivo") MultipartFile imagen )
	{
		if(!imagen.isEmpty())
		{
			Path ruta=Paths.get("imagenes/categoria");
			
			//String rutaAbsoluta="src//main//resources//static//imagenes//categoria";
			
			try 
			{
				//InputStream imagenes=imagen.getInputStream();
				
			    //byte[] bytesImagen=imagen.getBytes();
				//Path rutaCompleta=Paths.get(ruta+"/"+imagen.getOriginalFilename());
				
				//Files.write(rutaCompleta,bytesImagen);
				
				//byte[] imagenen64=Base64.getEncoder().encode(imagen.getBytes());
				Map result=servicioImagen.SubirImagen(imagen);
				categoria.setImagen(result.get("url").toString());
				
				boolean res=servicioCategoria.Agregar(categoria);
				if (res) {
					
					return "redirect:/Categoria/Listar";
				}
				
				
				
			} catch (Exception e) {
				
				modelo.addAttribute("error",e.getMessage());
				
				return "Categoria/Agregar";
			}
		}
		
		
		
		modelo.addAttribute("error",servicioCategoria.getMensaje());
		return "Categoria/Agregar";
	}
	
	@GetMapping("/Categoria/Eliminar/{IdCategoria}")
	public String Eliminar(@PathVariable int IdCategoria,Model modelo)
	{
		
		if (!servicioCategoria.Eliminar(IdCategoria))
		{
			modelo.addAttribute("error",servicioCategoria.getMensaje());
			
			return "redirect:/Categoria/Listar";
		}
		
		modelo.addAttribute("error",servicioCategoria.getMensaje());
		
		return "redirect:/Categoria/Listar";
	}

}
