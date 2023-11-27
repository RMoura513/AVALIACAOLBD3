package br.du.fatec.zl.CrudJavaWebSpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Professor;

public interface IProfessorRepository extends JpaRepository<Professor, Integer>{

}
