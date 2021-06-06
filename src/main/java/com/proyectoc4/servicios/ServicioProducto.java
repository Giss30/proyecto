package com.proyectoc4.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoc4.modelo.Producto;

@Service
public class ServicioProducto {

	@Autowired
	private RepoProducto repoProducto;
	
	private String Mensaje;
	
	public String getMensaje(){
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje=mensaje;
	}
	
	public boolean Agregar(Producto producto) 
	{
		try 
		{
			repoProducto.save(producto);
			
			this.Mensaje="Registrado Correctamente.";
			return true;
			
		} catch (Exception e)
		{
			// TODO: handle exception
			this.Mensaje="Error al registrar el producto";
			
			return false;
		}
	}
	
	public boolean Eliminar(int IdProducto)
	{
		try 
		{
			repoProducto.deleteById(IdProducto);
			
			this.Mensaje="Eliminado Correctamente.";
			return true;
			
		} catch (Exception e)
		{
			// TODO: handle exception
			this.Mensaje="Error al eliminar el producto";
			
			return false;
		}
	}
	
	public Iterable<Producto> Verproductos()
	{
		try 
		{
			this.Mensaje="";
			
			return repoProducto.findAll();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			this.Mensaje=e.getMessage();
			
			return null;
		}
	}
	
	public Producto BuscarProducto(int id) {
		try 
		{
			Producto producto=repoProducto.findById(id).get();
			
			return producto==null ? new Producto():producto;
		} catch (Exception e) {
			// TODO: handle exception
			this.Mensaje="No se pudo reslizar la búsqueda del prodcuto.";
			
			return null;
		}
	}
}
