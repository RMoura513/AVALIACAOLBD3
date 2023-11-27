package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Matricula;

public interface ISituacaoService {

	void iudMatricula(Matricula ma);

	List<Matricula> getAllMatriculas(int alunoRA);

}
