package com.warley.consultor.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warley.consultor.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	public Empresa findEmpresaById(long id);


	//  O nome da empresa mais antiga - OK;
	@Query(value = "SELECT * FROM empresa.empresa ORDER BY data_fundacao ASC limit 1", nativeQuery = true)
	List<Empresa> pesquisarEmpresaMaisAntiga();

	// A região do brasil que tem maior número de empresas do setor Industrial
	@Query(value = "SELECT *, count(regiao_brasil) from empresa.empresa WHERE setor_atuacao = 'Industrial' GROUP BY regiao_brasil  ORDER BY count(regiao_brasil) desc limit 1", nativeQuery = true)
	List <Empresa> pesquisarRegiaoMaisIndustrial();

	// O número de empresas de cada setor de atuação em ordem decrescente
	@Query(value = "SELECT setor_atuacao, count(*) as quantidade from empresa.empresa GROUP BY setor_atuacao ORDER BY quantidade desc", nativeQuery = true)
	List<Empresa> pesquisarNumEmpresasSetor();
}
