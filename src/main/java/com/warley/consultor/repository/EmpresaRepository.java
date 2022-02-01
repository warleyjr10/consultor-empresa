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

	@Query(value = "select regiao_brasil, sum(numero_de_funcionarios)from empresa.empresa group by regiao_brasil order by sum(numero_de_funcionarios) desc")
	List<Empresa> pesquisarProdutos(String regiaoBrasil, String numeroDeFuncionarios);

}
