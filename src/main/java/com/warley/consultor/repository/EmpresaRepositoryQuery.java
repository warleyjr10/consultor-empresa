package com.warley.consultor.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warley.consultor.model.EmpresaQuery;

@Repository
public interface EmpresaRepositoryQuery extends JpaRepository<EmpresaQuery, Long> {
	
	
	public EmpresaQuery findEmpresaQueryById(long id);
	//
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO empresa.empresaquery (quantidade) SELECT sum(numero_funcionarios) as quantidade FROM empresa.empresa", nativeQuery = true)
	int pesquisarNumTotalFuncionarios();
	
	@Query(value = "SELECT id, quantidade FROM empresa.empresaquery order by quantidade DESC limit 1", nativeQuery = true)
	List<EmpresaQuery> listarNumTotalFuncionarios();

}
