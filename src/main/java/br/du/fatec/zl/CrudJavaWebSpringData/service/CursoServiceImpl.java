package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Curso;
import br.du.fatec.zl.CrudJavaWebSpringData.repository.ICursoRepository;

@Service
public class CursoServiceImpl implements ICursoService{

	@Autowired
	private ICursoRepository iCursoRepository;
	
	@Override
	public List<Curso> getAllCursos() {
		return iCursoRepository.findAll();

	}

}
