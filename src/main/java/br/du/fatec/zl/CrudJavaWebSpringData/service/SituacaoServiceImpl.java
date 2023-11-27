package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Matricula;
import br.du.fatec.zl.CrudJavaWebSpringData.repository.IMatriculaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class SituacaoServiceImpl implements ISituacaoService {

	@Autowired
	private IMatriculaRepository matriculaRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Matricula> getAllMatriculas(int alunoRA) {
		return matriculaRepository.findByAlunoRA(alunoRA);
	}

	@Override
	public void iudMatricula(Matricula ma) {
		if (ma.getCodigo() == 0) {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_fazer_matricula");
			query.registerStoredProcedureParameter("cmd", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("alunoRA", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("disciplinaCodigo", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("situacao", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("diaSemana", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("saida", String.class, ParameterMode.OUT);

			query.setParameter("cmd", "I");
			query.setParameter("alunoRA", ma.getAlunoRA());
			query.setParameter("disciplinaCodigo", ma.getDisciplinaCodigo());
			query.setParameter("situacao", ma.getSituacao());
			query.setParameter("diaSemana", ma.getDiaSemana());

			query.execute();
			String saida = (String) query.getOutputParameterValue("saida");
		} else {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_fazer_matricula");
			query.registerStoredProcedureParameter("cmd", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("alunoRA", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("disciplinaCodigo", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("situacao", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("diaSemana", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("saida", String.class, ParameterMode.OUT);

			query.setParameter("cmd", "U");
			query.setParameter("alunoRA", ma.getAlunoRA());
			query.setParameter("disciplinaCodigo", ma.getDisciplinaCodigo());
			query.setParameter("situacao", ma.getSituacao());
			query.setParameter("diaSemana", ma.getDiaSemana());

			query.execute();
			String saida = (String) query.getOutputParameterValue("saida");
		}
	}

}
