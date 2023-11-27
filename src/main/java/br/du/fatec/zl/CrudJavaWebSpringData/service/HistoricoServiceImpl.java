package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Historico;
import br.du.fatec.zl.CrudJavaWebSpringData.repository.IHistoricoRepository;

@Service
public class HistoricoServiceImpl implements IHistoricoService {

    @Autowired
    private IHistoricoRepository historicoRepository;

    @Override
    public List<Historico> getAllHistorico1(int alunoRA) {
        return historicoRepository.findAllHistorico1(alunoRA);
    }

    @Override
    public List<Historico> getAllHistorico2(int alunoRA) {
        return historicoRepository.findAllHistorico2(alunoRA);
    }
}
