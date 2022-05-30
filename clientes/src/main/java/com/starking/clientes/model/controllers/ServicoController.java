package com.starking.clientes.model.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.starking.clientes.controllers.dtos.ServicoDTO;
import com.starking.clientes.model.entities.Servico;
import com.starking.clientes.services.ServicoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/servico")
@RequiredArgsConstructor
public class ServicoController {
	
	private final ServicoService servicoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico salva(ServicoDTO servicoDTO) {
		return this.servicoService.salvar(servicoDTO);
	}

}
