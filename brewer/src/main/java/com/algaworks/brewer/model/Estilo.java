package com.algaworks.brewer.model;

import org.hibernate.validator.constraints.NotBlank;

public class Estilo {
	
	@NotBlank(message = "Nome do Estilo é Obrigatório")
	String nome;
}
