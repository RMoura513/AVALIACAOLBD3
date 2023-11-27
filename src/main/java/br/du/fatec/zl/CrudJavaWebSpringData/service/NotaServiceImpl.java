package br.du.fatec.zl.CrudJavaWebSpringData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Nota;
import br.du.fatec.zl.CrudJavaWebSpringData.repository.INotaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotaServiceImpl implements INotaService{

	@Autowired
	private INotaRepository notaRepository;

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Nota> getAllNotas() {
		return (List<Nota>) notaRepository.findAll();
	}

	@Override
	public void saveNota(Nota no) {
		
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_inserir_nota");
			query.registerStoredProcedureParameter("alunoRA", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("disciplinaCodigo", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("notaP1", Float.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("notaP2", Float.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("notaP3", Float.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("notaT", Float.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("notaA", Float.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("notaM", Float.class, ParameterMode.IN);
		
			
			query.setParameter("alunoRA", no.getAlunoRA());
			query.setParameter("disciplinaCodigo", no.getDisciplinaCodigo());
			query.setParameter("notaP1", no.getNotaP1());
			query.setParameter("notaP2", no.getNotaP2());
			query.setParameter("notaP3", no.getNotaP3());
			query.setParameter("notaT", no.getNotaT());
			query.setParameter("notaA", no.getNotaA());
			query.setParameter("notaM", no.getNotaM());
		
			query.execute();
		
	}

}
