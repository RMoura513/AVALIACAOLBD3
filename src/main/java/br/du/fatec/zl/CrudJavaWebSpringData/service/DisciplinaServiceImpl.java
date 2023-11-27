package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Disciplina;
import br.du.fatec.zl.CrudJavaWebSpringData.repository.IDisciplinaRepository;

@Service
public class DisciplinaServiceImpl implements IDisciplinaService{

	@Autowired
	private IDisciplinaRepository iDisciplinaRepository;
	
	@Override
	public List<Disciplina> getAllDisciplinas() {
		return iDisciplinaRepository.findAll();
	}

	@Override
	public Disciplina getDisciplinaById(int id) {
		return iDisciplinaRepository.findById(id).get();
	}

	
	
}
