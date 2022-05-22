package com.starking.clientes.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.starking.clientes.model.entities.Cliente;
import com.starking.clientes.repositories.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
}
