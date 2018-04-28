package com.algaworks.brewer.model;

import org.hibernate.validator.constraints.NotBlank;

public class Usuario {

	@NotBlank(message= "Nome é Obrigatório")
	String nome;
	
	@NotBlank(message = "Senha é Obrigatória")
	String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
