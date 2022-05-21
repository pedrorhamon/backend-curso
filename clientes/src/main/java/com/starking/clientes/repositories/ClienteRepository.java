package com.starking.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starking.clientes.model.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
