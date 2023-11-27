package br.du.fatec.zl.CrudJavaWebSpringData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Relatorio;

public interface IRelatoriosRepository extends JpaRepository<Relatorio, Integer> {

	@Query(nativeQuery = true, value = "SELECT codigo, alunoRA, alunoNome, disciplinaNome, qtdAusenciasNaSemana, totalAusencias, estado FROM dbo.fn_relatorio_faltas()")
	List<Relatorio> findAllRelatorios();

}
