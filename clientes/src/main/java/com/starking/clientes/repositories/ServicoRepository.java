package com.starking.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starking.clientes.model.entities.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
