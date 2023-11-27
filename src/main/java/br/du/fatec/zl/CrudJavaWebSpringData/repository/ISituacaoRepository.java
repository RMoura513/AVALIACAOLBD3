package br.du.fatec.zl.CrudJavaWebSpringData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Matricula;

public interface ISituacaoRepository extends JpaRepository<Matricula, Integer>{
	
	List<Matricula> findByAlunoRA(int alunoRA);

}
