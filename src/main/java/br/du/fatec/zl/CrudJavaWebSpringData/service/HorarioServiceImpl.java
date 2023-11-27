package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Horario;
import br.du.fatec.zl.CrudJavaWebSpringData.repository.IHorarioRepository;

@Service
public class HorarioServiceImpl implements IHorarioService {

	@Autowired
	IHorarioRepository iHorarioRepository;

	@Override
	public List<Horario> getAllHorarios() {
		return iHorarioRepository.findAll();

	}

}
