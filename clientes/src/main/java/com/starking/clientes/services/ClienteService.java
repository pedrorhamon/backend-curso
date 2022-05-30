package com.starking.clientes.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.starking.clientes.model.entities.Cliente;
import com.starking.clientes.repositories.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	
	private final ClienteRepository clienteRepository;
	
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
	
	@Transactional
	public void deletar(Long id) {
		this.clienteRepository.deleteById(id);
	}
	
	
	@Transactional
	public void atualizar(Long id, Cliente cliente) {
		this.clienteRepository.findById(id)
		.map(clienteAtualizado -> {
			clienteAtualizado.setId(cliente.getId());
			return this.clienteRepository.save(clienteAtualizado);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Cliente não encontrado"));
	}
}
