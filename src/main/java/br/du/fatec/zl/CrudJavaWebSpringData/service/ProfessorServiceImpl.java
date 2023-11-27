package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Professor;
import br.du.fatec.zl.CrudJavaWebSpringData.repository.IProfessorRepository;

@Service
public class ProfessorServiceImpl implements IProfessorService {

	@Autowired
	private IProfessorRepository iProfessorRepository;

	@Override
	public List<Professor> getAllProfessores() {
		return iProfessorRepository.findAll();
	}

	@Override
	public void saveProfessor(Professor professor) {
		this.iProfessorRepository.save(professor);
	}

	@Override
	public Professor getProfessorById(int id) {
		return iProfessorRepository.findById(id).get();
	}

}
