package br.du.fatec.zl.CrudJavaWebSpringData.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "conteudo")
public class Conteudo {

	@Id
	@Column(name = "codigo", nullable = false)
	private int codigo;

	@OneToOne(targetEntity = Disciplina.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "disciplinaCodigo", nullable = false)
	private Disciplina disciplinaCodigo;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getDisciplinaCodigo() {
		return (disciplinaCodigo != null) ? disciplinaCodigo.getCodigo() : 0;
	}

	public void setDisciplinaCodigo(Disciplina disciplinaCodigo) {
		this.disciplinaCodigo = disciplinaCodigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
