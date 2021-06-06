package com.proyectoc4.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoc4.modelo.Detalleventa;

@Service
public class ServicioDetalleVenta {
	
	@Autowired
	RepoDetalleVenta repoDetalleVenta;
	
    private String Mensaje;
	
	public String getMensaje(){
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje=mensaje;
	}
	
	public boolean AgregarDetalleVenta(Detalleventa detalleventa) 
	{
		try 
		{
			repoDetalleVenta.save(detalleventa);
			
			this.Mensaje="Registrado Correctamente.";
			return true;
			
		} catch (Exception e)
		{
			// TODO: handle exception
			this.Mensaje="Error al registrar la venta";
			
			return false;
		}
	}
	
	public Iterable<Detalleventa> ListaDetalleVenta(int Idventa)
	{
		try 
		{
			this.Mensaje="";
			 return repoDetalleVenta.ListaDetalleVenta(Idventa);
			 
		} catch (Exception e) 
		{
			// TODO: handle exception
			this.Mensaje=e.getMessage();
			
			return null;
		}
	}

}
