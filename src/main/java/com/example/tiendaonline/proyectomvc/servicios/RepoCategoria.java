package com.example.tiendaonline.proyectomvc.servicios;

import org.springframework.data.repository.CrudRepository;

import com.example.tiendaonline.proyectomvc.modelo.Categoria;

public interface RepoCategoria extends CrudRepository <Categoria, Integer> {

}
