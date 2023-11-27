package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Historico;

public interface IHistoricoService {

	List<Historico> getAllHistorico1(int alunoRA);

	List<Historico> getAllHistorico2(int alunoRA);

}
