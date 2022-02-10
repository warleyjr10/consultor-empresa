package com.warley.consultor.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warley.consultor.model.Empresa;
import com.warley.consultor.model.EmpresaQuery;

@Repository
public interface EmpresaRepositoryQuery extends JpaRepository<EmpresaQuery, Long> {
	
	
	public EmpresaQuery findEmpresaQueryById(long id);
	//
	@Modifying
	@Transactional
	@Query(value = "UPDATE empresa.empresaquery SET quantidade = (SELECT sum(numero_funcionarios) as quantidade FROM empresa.empresa) WHERE id = '1'", nativeQuery = true)
	int pesquisarNumTotalFuncionarios();
	
	@Query(value = "SELECT id, quantidade FROM empresa.empresaquery order by quantidade DESC limit 1", nativeQuery = true)
	List<EmpresaQuery> listarNumTotalFuncionarios();
	
	// Nome da região do brasil que apresenta maior número de funcionários, e o número de funcionários
	@Query(value ="SELECT regiao_brasil, sum(numero_funcionarios) AS quantidade_funcionarios from empresa.empresa GROUP BY regiao_brasil ORDER BY quantidade_funcionarios desc", nativeQuery = true)
	List<Empresa> pesquisarRegiaoComMaisFuncionarios();
	
}
