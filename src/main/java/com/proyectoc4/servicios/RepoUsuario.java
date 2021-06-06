package com.proyectoc4.servicios;

import org.springframework.data.repository.CrudRepository;

import com.proyectoc4.modelo.Usuario;

public interface RepoUsuario extends CrudRepository <Usuario, Integer> {

}
