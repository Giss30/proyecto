package com.example.tiendaonline.proyectomvc.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tiendaonline.proyectomvc.modelo.Direccion;

@Service
public class ServicioDireccion {
	
	@Autowired
	RepoDireccion repoDireccion;
	
	 private String Mensaje;
		
		public String getMensaje(){
			return Mensaje;
		}
		
		public void setMensaje(String mensaje) {
			Mensaje=mensaje;
		}
		
		public boolean Agregar(Direccion direccion)
		{
			try 
			{
				repoDireccion.save(direccion);
				
				this.Mensaje="Registrado Correctamente.";
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				
				this.Mensaje="Error al registrar."+e;
				
				return false;
			}
		}
		
		public Iterable<Direccion> VerMisDirecciones (int idUsuario)
		{
			try 
			{
				this.Mensaje="";
				 return repoDireccion.ListaDirecionUsuario(idUsuario);
				 
			} catch (Exception e) 
			{
				// TODO: handle exception
				this.Mensaje=e.getMessage();
				
				return null;
			}
		}
}
