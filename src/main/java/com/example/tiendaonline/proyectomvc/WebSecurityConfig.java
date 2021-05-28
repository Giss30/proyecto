package com.example.tiendaonline.proyectomvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration 
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().antMatchers( //Rutas con acceso libre
				"/",
				"/css/**",
				"/js/**",
				"/imagenes/**",
				"/Carrito/Agregar",
				"/Producto/VerProductos",
				"/Carrito/VerProductos",
				"/Carrito/Eliminar",
				"/Usuario/Agregar",
				"/Acceso/Login"
				).permitAll()
		.anyRequest().authenticated() //cualquier otra ruta es con token
		.and().
		formLogin()
		.loginPage("/Acceso/Login") //Esta ruta se utiliza para validar al usuario 
		.successForwardUrl("/Acceso/Login")
		.permitAll()
		.and()
		.logout()
		.permitAll();
	}
}
