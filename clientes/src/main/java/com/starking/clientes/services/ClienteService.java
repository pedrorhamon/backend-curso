package com.starking.clientes.services;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.starking.clientes.model.entities.Cliente;
import com.starking.clientes.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional(readOnly = true)
	public Cliente findById(Long id){
		Cliente clienteID = clienteRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Cliente não encontrado"));
		return clienteID;
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
}
