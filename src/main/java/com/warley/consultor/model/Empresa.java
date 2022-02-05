package com.warley.consultor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@Transient
	private Long quantidade;
	@Transient
	private Long numero;
	
	public Empresa() {
		super();
		this.id = id;
		this.nomeDaEmpresa = nomeDaEmpresa;
		this.dataDeFundacao = dataDeFundacao;
		this.numeroDeFuncionarios = numeroDeFuncionarios;
		this.regiaoBrasil = regiaoBrasil;
		this.setorAtuacao = setorAtuacao;
		this.quantidade = quantidade;
	}
	public Empresa(Long quantidade, Long numero) {
		this.quantidade = quantidade;
		this.numero = numero;
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

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
}
