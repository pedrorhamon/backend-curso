package com.starking.clientes.model.entities;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 150)
	private String nome;

	@Column(nullable = false, length = 11)
	private String cpf;

	@Column(name = "data_cadastro")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;

	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}
}
