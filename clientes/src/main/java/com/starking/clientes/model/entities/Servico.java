package com.starking.clientes.model.entities;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 150)
	private String descricao;
	
	@JoinColumn(name = "id_cliente")
	@ManyToOne
	private Cliente cliente;
	
	@Column
	private BigDecimal valor;

}
