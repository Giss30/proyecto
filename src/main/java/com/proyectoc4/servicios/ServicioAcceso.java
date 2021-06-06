package com.proyectoc4.servicios;

import java.security.MessageDigest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoc4.modelo.Usuario;

@Service
public class ServicioAcceso {
	
	@Autowired
	private RepoAcceso repoAcceso;
	
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	private String Mensaje;
	
	public int TipoUsuario;
    public String Nombre;
    public int IdUsuario;
    
    public String getMensaje(){
		return Mensaje;
	}
	
	public void setMensaje(String mensaje)
	{
		Mensaje=mensaje;
	}
	
	public int setTipoUsuario()
	{
		return TipoUsuario;
	}
	
	public String setNombre()
	{
		return Nombre;
	}
	
	public int setIdUsuario()
	{
		return IdUsuario;
	}
	
	public boolean ValidarUsuario(String Correo, String Contrasena,HttpSession sesion)
	{
		try
		{
			Usuario usuario=repoAcceso.ValidarAcceso(Correo,servicioUsuario.encriptar(Contrasena));
			
			if(usuario!=null)
			{
				Nombre=usuario.getNombre();
				TipoUsuario=usuario.getRol().getIdrol();
				IdUsuario=usuario.getIdusuario();	
				sesion.setAttribute("nombreusuario", usuario.getNombre());
				sesion.setAttribute("idusuario", usuario.getIdusuario());
				sesion.setAttribute("tipousuario", usuario.getRol().getIdrol());
				return true;
			}
			
			Mensaje="Datos incorrectos"+usuario;
			return false;
			
		} catch (Exception e) {
		// TODO: handle exception
			
			Mensaje="Ocurrio un erro al verficar los datos del usuario.";
			
			return false;
		}
		
	}
	
	private byte[] encriptar(String clave) {
		try {
			MessageDigest digest=MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(clave.getBytes("utf8"));
			
			return digest.digest();
			
		}catch(Exception e) {
			return null;
		}
		
	}
}
