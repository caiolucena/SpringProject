package com.algaworks.brewer.model;

import org.hibernate.validator.constraints.NotBlank;

public class Cliente {
	
	@NotBlank(message= "Nome é Obrigatório")
	String nome;
	
	@NotBlank(message ="Cpf é Obrigatório")
	String cpf;
	
	@NotBlank(message = "Telefone é Obrigatório")
	String telefone;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

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
