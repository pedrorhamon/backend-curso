package com.starking.clientes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.starking.clientes.model.entities.Cliente;
import com.starking.clientes.services.ClienteService;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {
	
	private ClienteService clienteService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(Cliente cliente) {
		return this.clienteService.salvar(cliente);
	}
}
