package com.proyectoc4.servicios;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoc4.modelo.Usuario;

@Service
public class ServicioUsuario {

	@Autowired
	private RepoUsuario repoUsuario;
	
    private String Mensaje;
	
	public String getMensaje(){
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje=mensaje;
	}
	
	public boolean Agregar(Usuario usuario,String Contrasena)
	{
		try 
		{
			usuario.setContrasena(encriptar(Contrasena));
		
			
			repoUsuario.save(usuario);
			
			this.Mensaje="Registrado Correctamente.";
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			
			this.Mensaje="Error al registrar."+e;
			
			return false;
		}
	}
	
	public byte[] encriptar(String clave) {
		try {
			MessageDigest digest=MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(clave.getBytes("utf8"));
			
			return digest.digest();
			
		}catch(Exception e) {
			return null;
		}
		
	}
	
	
	public Usuario BuscarUsuario(int id) {
		try 
		{
			Usuario usuario=repoUsuario.findById(id).get();
			
			return usuario==null ? new Usuario():usuario;
		} catch (Exception e) {
			// TODO: handle exception
			this.Mensaje="No se pudo reslizar la búsqueda del usuario";
			
			return null;
		}
	}
	
	public Iterable<Usuario> ListarUsuarios(){
		
		try 
		{
			this.Mensaje="";
			 return repoUsuario.findAll();
			 
		} catch (Exception e) 
		{
			// TODO: handle exception
			this.Mensaje=e.getMessage();
			
			return null;
		}
	}
	
}
