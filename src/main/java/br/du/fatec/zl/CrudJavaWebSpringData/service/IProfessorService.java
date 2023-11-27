package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Professor;

public interface IProfessorService {
	List<Professor> getAllProfessores();

	void saveProfessor(Professor professor);

	public Professor getProfessorById(int id);

}
