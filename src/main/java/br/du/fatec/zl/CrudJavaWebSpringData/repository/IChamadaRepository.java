package br.du.fatec.zl.CrudJavaWebSpringData.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Chamada;

public interface IChamadaRepository extends JpaRepository<Chamada, Integer> {
    List<Chamada> findByDisciplinaCodigo(int disciplinaCodigo);
    
    @Query("SELECT c FROM Chamada c WHERE c.disciplinaCodigo = :disciplinaCodigo AND c.alunoRA = :alunoRA AND c.dataChamada = :dataChamada")
    List<Chamada> findByDisciplinaCodigoAndAlunoRAAndDataChamada(
        @Param("disciplinaCodigo") int disciplinaCodigo,
        @Param("alunoRA") int alunoRA,
        @Param("dataChamada") LocalDate dataChamada
    );

    @Procedure("sp_consulta_chamada")
    void executarConsultaChamada(@Param("disciplinaCodigo") int disciplinaCodigo);
}
    
    

