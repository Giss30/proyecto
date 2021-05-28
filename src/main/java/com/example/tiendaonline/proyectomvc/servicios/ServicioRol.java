package com.example.tiendaonline.proyectomvc.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tiendaonline.proyectomvc.modelo.Rol;

@Service
public class ServicioRol {

	@Autowired
	private RepoRol repoRol;
	
    private String Mensaje;
	
	public String getMensaje(){
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje=mensaje;
	}
	
	public Rol BuscarRol(int id) {
		try 
		{
			Rol rol=repoRol.findById(id).get();
			
			return rol==null ? new Rol():rol;
		} catch (Exception e) {
			// TODO: handle exception
			this.Mensaje="No se pudo reslizar la búsqueda del rol para el usuario"+e.getMessage();
			
			return null;
		}
	}
}
