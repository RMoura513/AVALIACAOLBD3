package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Conteudo;
import br.du.fatec.zl.CrudJavaWebSpringData.repository.IConteudoRepository;

@Service
public class ConteudoServiceImpl implements IConteudoService {

	@Autowired
	private IConteudoRepository iConteudoRepository;
	
	@Override
	public List<Conteudo> getAllConteudos() {
		return iConteudoRepository.findAll();
	}

}
