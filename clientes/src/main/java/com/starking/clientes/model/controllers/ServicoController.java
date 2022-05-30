package com.starking.clientes.model.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Servico> buscar(
			@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "mes", required = false) Integer mes) {
		return this.servicoService.buscar(nome, mes);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico salvar(@RequestBody ServicoDTO servicoDTO) {
		return this.servicoService.salvar(servicoDTO);
	}

}
