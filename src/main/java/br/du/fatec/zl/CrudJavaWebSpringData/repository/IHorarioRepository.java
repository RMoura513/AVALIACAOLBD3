package br.du.fatec.zl.CrudJavaWebSpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Horario;

public interface IHorarioRepository extends JpaRepository<Horario, Integer>{

}
