package com.algaworks.brewer.model;

import org.hibernate.validator.constraints.NotBlank;

public class Cidade {
	
	@NotBlank(message ="Estado Obrigatório")
	String estado;
	
	@NotBlank(message = "Nome da Cidade é Obrigatório")
	String nome;
	
}
