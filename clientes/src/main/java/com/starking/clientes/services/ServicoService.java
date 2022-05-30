package com.starking.clientes.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.starking.clientes.controllers.dtos.ServicoDTO;
import com.starking.clientes.model.entities.Cliente;
import com.starking.clientes.model.entities.Servico;
import com.starking.clientes.repositories.ClienteRepository;
import com.starking.clientes.repositories.ServicoRepository;
import com.starking.clientes.utils.BigDecimalConverter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoService {

	private final ServicoRepository servicoRepository;
	private final ClienteRepository clienteRepository;
	private final BigDecimalConverter bigDecimalConverte;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico salvar(ServicoDTO servicoDTO) {
		LocalDate data = LocalDate.parse(servicoDTO.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Long idCliente = servicoDTO.getIdCliente();
		Cliente clienteID = clienteRepository.findById(idCliente)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"Cliente inexistente"));
		
		Servico servico = new Servico();
		servico.setDescricao(servicoDTO.getDescricao());
		servico.setData(data);
		servico.setCliente(clienteID);
		servico.setValor(bigDecimalConverte.converter(servicoDTO.getPreco()));
		
		return this.servicoRepository.save(servico);
	}
	
}
