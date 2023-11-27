package br.du.fatec.zl.CrudJavaWebSpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.du.fatec.zl.CrudJavaWebSpringData.model.Conteudo;

public interface IConteudoRepository extends JpaRepository<Conteudo, Integer>{

}
