package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Aluno;

public interface IAlunoService {

	List<Aluno> getAllAlunos();

	void saveAluno(Aluno aluno);

	public Aluno getAlunoById(int id);

	void deleteAluno(int id);

}
