package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Disciplina;

public interface IDisciplinaService {

	List<Disciplina> getAllDisciplinas();

	public Disciplina getDisciplinaById(int id);

}
