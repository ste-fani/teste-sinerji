package com.projeto.entities;

public enum TipoSexo {

	FEMININO("Feminino"), 
	MASCULINO("Masculino");

	private String sexo;

	TipoSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}
}
