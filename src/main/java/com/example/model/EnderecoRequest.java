package com.example.model;

import javax.validation.constraints.NotNull;

public class EnderecoRequest {
	
	@NotNull
	private String cep;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

}
