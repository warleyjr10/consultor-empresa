package com.warley.consultor.model;

public class RegiaoComMaisFuncionariosDTO {

	private int quantidadeFuncionarios;
	private String regiaoBrasil;

	public RegiaoComMaisFuncionariosDTO(String regiaoBrasil, int quantidadeFuncionarios) {

		this.regiaoBrasil = regiaoBrasil;
		this.quantidadeFuncionarios = quantidadeFuncionarios;

	}

	public int getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}

	public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}

	public String getRegiaoBrasil() {
		return regiaoBrasil;
	}

	public void setRegiaoBrasil(String regiaoBrasil) {
		this.regiaoBrasil = regiaoBrasil;
	}

}
