package com.example.tiendaonline.proyectomvc.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tiendaonline.proyectomvc.modelo.Venta;

@Service
public class ServicioVenta {

	@Autowired
	RepoVenta repoVenta;

	
	private String Mensaje;
	
	public String getMensaje(){
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje=mensaje;
	}
	
	public boolean AgregarVenta(Venta venta) 
	{
		try 
		{
			repoVenta.save(venta);
			
			this.Mensaje="Registrado Correctamente.";
			return true;
			
		} catch (Exception e)
		{
			// TODO: handle exception
			this.Mensaje="Error al registrar la venta"+e.getMessage();
			
			return false;
		}
	}
	
	public Iterable<Venta> MisCompras(int IdUsuario)
	{
		try 
		{
			this.Mensaje="";
			 return repoVenta.ListaVentasComprasIdUsuario(IdUsuario);
			 
		} catch (Exception e) 
		{
			// TODO: handle exception
			this.Mensaje=e.getMessage();
			
			return null;
		}
	}
	
	public Iterable<Venta> MisVentas()
	{
		try 
		{
			this.Mensaje="";
			 return repoVenta.findAll();
			 
		} catch (Exception e) 
		{
			// TODO: handle exception
			this.Mensaje=e.getMessage();
			
			return null;
		}
	}
	
	
	public Venta UltimoRegistroVenta(int Id)
	{
		try 
		{
			
			Venta venta=repoVenta.findById(Id).get();
			
			return venta==null ? new Venta():venta;
		} catch (Exception e) {
			// TODO: handle exception
			this.Mensaje="No se pudo reslizar la búsqueda de la venta.";
			
			return null;
		}
	}
	
	
	public int IdUltimoRegistroVenta() {
		
		return repoVenta.UltimoRegistroVenta();
	}
}
