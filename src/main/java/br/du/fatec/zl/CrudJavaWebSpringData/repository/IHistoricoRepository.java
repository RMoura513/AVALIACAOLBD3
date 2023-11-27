package br.du.fatec.zl.CrudJavaWebSpringData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Historico;

public interface IHistoricoRepository extends JpaRepository<Historico, Integer> {

	@Query(nativeQuery = true, value = "SELECT codigo, alunoRA, alunoNome, cursoCodigo, disciplinaCodigo, disciplinaNome, cursoNome, "
			+ "dataMatricula, pontuacaoVestibular, posicaoVestibular, matriculaCodigo, matriculaC, notaFinal, professorNome, qtdAusencias FROM dbo.fn_historico1(:alunoRA)")
	List<Historico> findAllHistorico1(@Param("alunoRA") int alunoRA);

	@Query(nativeQuery = true, value = "SELECT codigo, alunoRA, alunoNome, cursoCodigo, disciplinaCodigo, disciplinaNome, cursoNome, "
			+ "dataMatricula, pontuacaoVestibular, posicaoVestibular, matriculaCodigo, matriculaC, notaFinal, professorNome, qtdAusencias FROM dbo.fn_historico2(:alunoRA)")
	List<Historico> findAllHistorico2(@Param("alunoRA") int alunoRA);
}
