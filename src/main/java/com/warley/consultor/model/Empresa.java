package com.warley.consultor.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.warley.consultor.model.RegiaoComMaisFuncionariosDTO;


@Entity
@Table(name = "empresa")
@NamedNativeQuery(name = "Empresa.pesquisarRegiaoComMaisFuncionarios",
query = "SELECT regiao_brasil as regiaoBrasil , sum(numero_funcionarios) as quantidadeFuncionarios from empresa.empresa GROUP BY regiao_brasil ORDER BY quantidadeFuncionarios desc",
resultSetMapping = "Mapping.RegiaoComMaisFuncionariosDTO")
@SqlResultSetMapping(name = "Mapping.RegiaoComMaisFuncionariosDTO", 
classes = @ConstructorResult(targetClass = RegiaoComMaisFuncionariosDTO.class, 
columns = {@ColumnResult(name = "regiaoBrasil"), 
		   @ColumnResult(name = "quantidadeFuncionarios") }))
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String dataFundacao;
	private int numeroFuncionarios;
	private String regiaoBrasil;
	private String setorAtuacao;
	
	public Empresa() {
		super();
		this.id = id;
		this.nome = nome;
		this.dataFundacao = dataFundacao;
		this.numeroFuncionarios = numeroFuncionarios;
		this.regiaoBrasil = regiaoBrasil;
		this.setorAtuacao = setorAtuacao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(String dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}
	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
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
