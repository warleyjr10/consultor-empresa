package com.warley.consultor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warley.consultor.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	Optional<Empresa> findById(Long id);

	@Query(value = "select *, sum(numero_de_funcionarios)from empresa.empresa group by regiao_brasil order by sum(numero_de_funcionarios) desc", nativeQuery = true)
	List<Empresa> pesquisarRegiaoNumFuncionarios();
	
	@Query(value = "SELECT * FROM empresa.empresa ORDER BY data_de_fundacao ASC", nativeQuery = true)
	List<Empresa> pesquisarEmpresaMaisAntiga();
	
	@Query(value = "SELECT *, count(setor_atuacao) as quantidade_regiao_mais_industrial FROM empresa.empresa WHERE setor_atuacao LIKE 'Industrial' GROUP BY regiao_brasil", nativeQuery = true)
	List<Empresa> pesquisarRegiaoMaisIndustrial();
	
	@Query(value = "SELECT setor_atuacao, count(*) FROM empresa.empresa GROUP BY setor_atuacao ORDER BY count(*) DESC", nativeQuery = true)
	List<Empresa> pesquisarNumEmpresasSetor();
	
	@Query(value = "SELECT SUM(numero_de_funcionarios) FROM empresa.empresa", nativeQuery = true)
	List<Empresa> pesquisarNumTotalFuncionarios();
	
}
