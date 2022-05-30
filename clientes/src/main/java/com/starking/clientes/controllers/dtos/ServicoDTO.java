package com.starking.clientes.controllers.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServicoDTO {
	
	private String descricao;
	private String preco;
	private String data;
	private Long idCliente;

}
