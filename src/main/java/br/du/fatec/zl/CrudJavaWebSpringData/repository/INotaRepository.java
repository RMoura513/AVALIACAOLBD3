package br.du.fatec.zl.CrudJavaWebSpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Nota;

public interface INotaRepository extends JpaRepository<Nota, Integer> {

}
