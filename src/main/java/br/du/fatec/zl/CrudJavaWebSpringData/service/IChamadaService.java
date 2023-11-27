package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.time.LocalDate;
import java.util.List;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Chamada;

public interface IChamadaService {
	List<Chamada> getChamadasByDisciplinaCodigo(int disciplinaCodigo);

	void processarChamada(int[] ausencias, int[] alunoRAs, int disciplinaCodigo, LocalDate dataChamada);

	List<Chamada> consultarChamada(int disciplinaCodigo);
	
	void executarConsultaChamada(int disciplinaCodigo);
	
}
