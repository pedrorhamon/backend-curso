package com.starking.clientes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.starking.clientes.model.entities.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
	
	@Query("SELECT "
			+ "s from Servico s join s.cliente c where upper(c.nome) like upper(%:nome) and MONTH(s.data) =:mes")
	List<Servico> findByNomeClienteAndMes(@Param("nome") String nome, @Param("mes") Integer mes);

}
