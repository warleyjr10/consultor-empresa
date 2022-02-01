package com.warley.consultor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomeDaEmpresa;
	private String dataDeFundacao;
	private String numeroDeFuncionarios;
	private String regiaoBrasil;
	private String setorAtuacao;
	
	public Empresa() {
		super();
		this.id = id;
		this.nomeDaEmpresa = nomeDaEmpresa;
		this.dataDeFundacao = dataDeFundacao;
		this.numeroDeFuncionarios = numeroDeFuncionarios;
		this.regiaoBrasil = regiaoBrasil;
		this.setorAtuacao = setorAtuacao;
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

	
}
