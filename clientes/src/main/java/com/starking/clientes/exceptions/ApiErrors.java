package com.starking.clientes.exceptions;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class ApiErrors {
	
	private List<String> erros;
	
	public ApiErrors(List<String> erros) {
		this.erros = erros;
	}
	
	public ApiErrors(String msg) {
		this.erros = Arrays.asList(msg);
	}

}
