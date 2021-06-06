package com.proyectoc4.servicios;

import org.springframework.data.repository.CrudRepository;

import com.proyectoc4.modelo.Categoria;

public interface RepoCategoria extends CrudRepository <Categoria, Integer> {

}
