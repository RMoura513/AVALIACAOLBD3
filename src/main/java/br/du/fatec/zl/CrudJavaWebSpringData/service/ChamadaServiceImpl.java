package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Chamada;
import br.du.fatec.zl.CrudJavaWebSpringData.repository.IChamadaRepository;

@Service
public class ChamadaServiceImpl implements IChamadaService {

	@Autowired
	private IChamadaRepository chamadaRepository;

	@Override
	public List<Chamada> getChamadasByDisciplinaCodigo(int disciplinaCodigo) {
		return chamadaRepository.findByDisciplinaCodigo(disciplinaCodigo);
	}

	@Override
	public void processarChamada(int[] ausencias, int[] alunoRAs, int disciplinaCodigo, LocalDate dataChamada) {
		for (int i = 0; i < ausencias.length; i++) {
			int ausencia = ausencias[i];
			int alunoRA = alunoRAs[i];

			List<Chamada> chamadas = chamadaRepository.findByDisciplinaCodigoAndAlunoRAAndDataChamada(disciplinaCodigo,
					alunoRA, dataChamada);
			if (chamadas.isEmpty()) {
				Chamada chamada = new Chamada();
				chamada.setAlunoRA(alunoRA);
				chamada.setDisciplinaCodigo(disciplinaCodigo);
				chamada.setAusencia(ausencia);
				chamada.setDataChamada(dataChamada);
				chamadaRepository.save(chamada);
			} else {
				Chamada chamadaExistente = chamadas.get(0);
				chamadaExistente.setAusencia(ausencia);
				chamadaRepository.save(chamadaExistente);
			}
		}
	}

	@Override
	public List<Chamada> consultarChamada(int disciplinaCodigo) {
		return chamadaRepository.findByDisciplinaCodigo(disciplinaCodigo);
	}
	
    @Override
    public void executarConsultaChamada(int disciplinaCodigo) {
        chamadaRepository.executarConsultaChamada(disciplinaCodigo);
    }

}
