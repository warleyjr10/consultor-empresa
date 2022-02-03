package com.warley.consultor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDaEmpresa;
	private String dataDeFundacao;
	private String numeroDeFuncionarios;
	private String regiaoBrasil;
	private String setorAtuacao;
	private String quantidadeRegiaoMaisIndustrial;
	
	public Empresa() {
		super();
		this.id = id;
		this.nomeDaEmpresa = nomeDaEmpresa;
		this.dataDeFundacao = dataDeFundacao;
		this.numeroDeFuncionarios = numeroDeFuncionarios;
		this.regiaoBrasil = regiaoBrasil;
		this.setorAtuacao = setorAtuacao;
		this.quantidadeRegiaoMaisIndustrial = quantidadeRegiaoMaisIndustrial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		this.nomeDaEmpresa = nomeDaEmpresa;
	}

	public String getDataDeFundacao() {
		return dataDeFundacao;
	}

	public void setDataDeFundacao(String dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}

	public String getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(String numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public String getRegiaoBrasil() {
		return regiaoBrasil;
	}

	public void setRegiaoBrasil(String regiaoBrasil) {
		this.regiaoBrasil = regiaoBrasil;
	}

	public String getSetorAtuacao() {
		return setorAtuacao;
	}

	public void setSetorAtuacao(String setorAtuacao) {
		this.setorAtuacao = setorAtuacao;
	}

	public String getQuantidadeRegiaoMaisIndustrial() {
		return quantidadeRegiaoMaisIndustrial;
	}

	public void setQuantidadeRegiaoMaisIndustrial(String quantidadeRegiaoMaisIndustrial) {
		this.quantidadeRegiaoMaisIndustrial = quantidadeRegiaoMaisIndustrial;
	}
	
}
