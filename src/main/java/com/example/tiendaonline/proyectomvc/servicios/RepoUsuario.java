package com.example.tiendaonline.proyectomvc.servicios;

import org.springframework.data.repository.CrudRepository;

import com.example.tiendaonline.proyectomvc.modelo.Usuario;

public interface RepoUsuario extends CrudRepository <Usuario, Integer> {

}
