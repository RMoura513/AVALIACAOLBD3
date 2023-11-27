package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Relatorio;
import br.du.fatec.zl.CrudJavaWebSpringData.repository.IRelatoriosRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RelatoriosServiceImpl implements IRelatoriosService{

	@Autowired
	IRelatoriosRepository relatoriosRepository;
	
	
	@Override
	public List<Relatorio> getAllRelatorios() {
		return relatoriosRepository.findAllRelatorios();
	}

}
