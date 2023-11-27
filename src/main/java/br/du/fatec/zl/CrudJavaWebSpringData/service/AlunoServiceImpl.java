package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Aluno;
import br.du.fatec.zl.CrudJavaWebSpringData.repository.IAlunoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AlunoServiceImpl implements IAlunoService {

	@Autowired
	IAlunoRepository iAlunoRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Aluno> getAllAlunos() {
		return (List<Aluno>) iAlunoRepository.findAll();
	}

	@Override
	public void saveAluno(Aluno aluno) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);

		if (aluno.getRA() == 0) {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_crud_aluno");
			query.registerStoredProcedureParameter("cmd", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("RA", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("cursoCodigo", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("turno", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("CPF", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("nome", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("nomeSocial", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("dataNascimento", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("tel", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("emailPes", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("emailCor", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("dataConclusaoSeg", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("instituicaoConclusaoSeg", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("pontuacaoVestibular", Float.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("posicaoVestibular", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("dataIngresso", String.class, ParameterMode.IN);
//           query.registerStoredProcedureParameter("semestreAnoIngresso", String.class, ParameterMode.IN);
//           query.registerStoredProcedureParameter("semestreAnoLimiteGrad", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("saida", String.class, ParameterMode.OUT);

			query.setParameter("cmd", "I");
			query.setParameter("RA", aluno.getRA());
			query.setParameter("cursoCodigo", aluno.getCursoCodigo());
			query.setParameter("turno", aluno.getTurno());
			query.setParameter("CPF", aluno.getCPF());
			query.setParameter("nome", aluno.getNome());
			query.setParameter("nomeSocial", aluno.getNomeSocial());
			query.setParameter("dataNascimento", aluno.getDataNascimento().format(dtf));
			query.setParameter("tel", aluno.getTel());
			query.setParameter("emailPes", aluno.getEmailPes());
			query.setParameter("emailCor", aluno.getEmailCor());
			query.setParameter("dataConclusaoSeg", aluno.getDataConclusaoSeg().format(dtf));
			query.setParameter("instituicaoConclusaoSeg", aluno.getInstituicaoConclusaoSeg());
			query.setParameter("pontuacaoVestibular", aluno.getPontuacaoVestibular());
			query.setParameter("posicaoVestibular", aluno.getPosicaoVestibular());
			query.setParameter("dataIngresso", aluno.getDataIngresso().format(dtf));
//            query.setParameter("semestreAnoIngresso", aluno.getSemestreAnoIngresso());
//            query.setParameter("semestreAnoLimiteGrad", aluno.getSemestreAnoLimiteGrad());

			query.execute();
			String saida = (String) query.getOutputParameterValue("saida");
		} else {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_crud_aluno");
			query.registerStoredProcedureParameter("cmd", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("RA", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("cursoCodigo", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("turno", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("CPF", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("nome", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("nomeSocial", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("dataNascimento", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("tel", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("emailPes", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("emailCor", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("dataConclusaoSeg", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("instituicaoConclusaoSeg", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("pontuacaoVestibular", Float.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("posicaoVestibular", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("dataIngresso", String.class, ParameterMode.IN);
//            query.registerStoredProcedureParameter("semestreAnoIngresso", String.class, ParameterMode.IN);
//            query.registerStoredProcedureParameter("semestreAnoLimiteGrad", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("saida", String.class, ParameterMode.OUT);

			query.setParameter("cmd", "I");
			query.setParameter("RA", aluno.getRA());
			query.setParameter("cursoCodigo", aluno.getCursoCodigo());
			query.setParameter("turno", aluno.getTurno());
			query.setParameter("CPF", aluno.getCPF());
			query.setParameter("nome", aluno.getNome());
			query.setParameter("nomeSocial", aluno.getNomeSocial());
			query.setParameter("dataNascimento", aluno.getDataNascimento().format(dtf));
			query.setParameter("tel", aluno.getTel());
			query.setParameter("emailPes", aluno.getEmailPes());
			query.setParameter("emailCor", aluno.getEmailCor());
			query.setParameter("dataConclusaoSeg", aluno.getDataConclusaoSeg().format(dtf));
			query.setParameter("instituicaoConclusaoSeg", aluno.getInstituicaoConclusaoSeg());
			query.setParameter("pontuacaoVestibular", aluno.getPontuacaoVestibular());
			query.setParameter("posicaoVestibular", aluno.getPosicaoVestibular());
			query.setParameter("dataIngresso", aluno.getDataIngresso().format(dtf));
//            query.setParameter("semestreAnoIngresso", aluno.getSemestreAnoIngresso());
//            query.setParameter("semestreAnoLimiteGrad", aluno.getSemestreAnoLimiteGrad());

			query.execute();
			String saida = (String) query.getOutputParameterValue("saida");
		}
	}

	@Override
	public Aluno getAlunoById(int id) {
		return iAlunoRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteAluno(int id) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_crud_aluno");
		query.registerStoredProcedureParameter("cmd", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("RA", Integer.class, ParameterMode.IN);

		query.setParameter("cmd", "D");
		query.setParameter("RA", id);

		query.execute();
	}
}
