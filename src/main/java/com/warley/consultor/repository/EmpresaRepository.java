package com.warley.consultor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warley.consultor.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	public Empresa findEmpresaById(long id);

	//Nome da região do brasil que apresenta maior número de funcionários, e o número de funcionários
	@Query(value = "SELECT * FROM empresa.empresa order by numero_de_funcionarios desc", nativeQuery = true)
	List<Empresa> pesquisarRegiaoNumFuncionarios();
	// O nome da empresa mais antiga;
	@Query(value = "SELECT * FROM empresa.empresa ORDER BY data_de_fundacao ASC", nativeQuery = true)
	List<Empresa> pesquisarEmpresaMaisAntiga();
	//A região do brasil que tem maior número de empresas do setor Industrial
	@Query(value = "SELECT *, count(setor_atuacao) as quantidade FROM empresa.empresa WHERE setor_atuacao LIKE 'Industrial' GROUP BY regiao_brasil", nativeQuery = true)
	List<Empresa> pesquisarRegiaoMaisIndustrial();
	//O número de empresas de cada setor de atuação em ordem decrescente
	@Query(value = "SELECT setor_atuacao,id,nome_da_empresa,numero_de_funcionarios,data_de_fundacao,regiao_brasil, count(*) as numero FROM empresa.empresa GROUP BY setor_atuacao ORDER BY count(*) DESC", nativeQuery = true)
	List<Empresa> pesquisarNumEmpresasSetor();
	//O número total de funcionários de todas as empresas
	@Query(value = "SELECT *, SUM(numero_de_funcionarios) as numero_total_empresas FROM empresa.empresa;", nativeQuery = true)
	List<Empresa> pesquisarNumTotalFuncionarios();



}
