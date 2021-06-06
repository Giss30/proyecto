package com.proyectoc4.servicios;

import org.springframework.data.repository.CrudRepository;

import com.proyectoc4.modelo.Producto;

public interface RepoProducto extends CrudRepository<Producto, Integer> {

}
