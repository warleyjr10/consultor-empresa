package com.warley.consultor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warley.consultor.model.Empresa;
import com.warley.consultor.model.RegiaoComMaisFuncionariosDTO;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	public Empresa findEmpresaById(long id);

	// Nome da região do brasil que apresenta maior número de funcionários, e o número de funcionários
	@Query(nativeQuery = true)
	List<RegiaoComMaisFuncionariosDTO> pesquisarRegiaoComMaisFuncionarios();

	//  O nome da empresa mais antiga - OK;
	@Query(value = "SELECT * FROM empresa.empresa ORDER BY data_fundacao ASC limit 1", nativeQuery = true)
	List<Empresa> pesquisarEmpresaMaisAntiga();

	// A região do brasil que tem maior número de empresas do setor Industrial
	@Query(value = "SELECT regiao_brasil, count(regiao_brasil) as quantidade from empresa.empresa WHERE setor_atuacao = 'Industrial' GROUP BY regiao_brasil  ORDER BY quantidade desc limit 1", nativeQuery = true)
	List<Empresa> pesquisarRegiaoMaisIndustrial();

	// O número de empresas de cada setor de atuação em ordem decrescente
	@Query(value = "SELECT setor_atuacao, count(*) as quantidade from empresa.empresa GROUP BY setor_atuacao ORDER BY quantidade desc", nativeQuery = true)
	List<Empresa> pesquisarNumEmpresasSetor();

	// O número total de funcionários de todas as empresas - OK 
	@Query(value = "SELECT * FROM empresa.empresa order by numero_funcionarios desc", nativeQuery = true)
	List<Empresa> pesquisarNumTotalFuncionarios();
}
