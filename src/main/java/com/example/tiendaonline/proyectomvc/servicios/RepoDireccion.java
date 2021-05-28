package com.example.tiendaonline.proyectomvc.servicios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.tiendaonline.proyectomvc.modelo.Direccion;

public interface RepoDireccion extends CrudRepository<Direccion, Integer> {

	@Query(value="SELECT * FROM direccion WHERE idusuario=?1",nativeQuery=true)
	ArrayList<Direccion> ListaDirecionUsuario(int IdUsuario);
}
