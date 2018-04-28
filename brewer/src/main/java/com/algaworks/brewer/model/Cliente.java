package com.algaworks.brewer.model;

import org.hibernate.validator.constraints.NotBlank;

public class Cliente {
	
	@NotBlank(message= "Nome é Obrigatório")
	String nome;
	
	@NotBlank(message ="Cpf é Obrigatório")
	String cpf;
	
	@NotBlank(message = "Telefone é Obrigatório")
	String telefone;
	
	@NotBlank(message = "Email é Obrigatório")
	String email;
	
	@NotBlank(message = "Logradouro é Obrigatório")
	String logradouro;
	
	int numero;
	
	String complemento;
	
	@NotBlank(message = "CEP é Obrigatório")
	String cep;
	
	@NotBlank(message = "Estado é Obrigatório")
	String Estado;
	
	@NotBlank(message = "Cidade é Obrigatória")
	String Cidade;
	
}
