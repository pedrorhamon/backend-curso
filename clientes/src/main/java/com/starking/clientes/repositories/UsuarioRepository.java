package com.starking.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starking.clientes.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
