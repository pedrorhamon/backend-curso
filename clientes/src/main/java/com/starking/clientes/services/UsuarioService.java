package com.starking.clientes.services;

import org.springframework.stereotype.Service;

import com.starking.clientes.model.entities.Usuario;
import com.starking.clientes.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	public void salvar(Usuario usuario) {
		this.usuarioRepository.save(usuario);
	}
}
