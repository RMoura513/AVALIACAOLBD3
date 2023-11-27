package br.du.fatec.zl.CrudJavaWebSpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Integer>{

}
