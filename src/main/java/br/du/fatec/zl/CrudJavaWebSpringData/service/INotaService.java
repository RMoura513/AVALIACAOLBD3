package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Nota;

public interface INotaService {

	List<Nota> getAllNotas();

	void saveNota(Nota no);

	//void deleteNota(int id);
	
}
