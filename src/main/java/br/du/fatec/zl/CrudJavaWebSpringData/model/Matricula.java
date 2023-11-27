package br.du.fatec.zl.CrudJavaWebSpringData.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@Table(name = "matricula")
@IdClass(MatriculaID.class)
public class Matricula {

	@Id
	@JoinColumn(name = "c", nullable = false)
	private int c;

	@Id
	@JoinColumn(name = "codigo", nullable = false)
	private int codigo;

	@Column(name = "alunoRA", nullable = false)
	private int alunoRA;

	@Column(name = "disciplinaCodigo", nullable = false)
	private int disciplinaCodigo;

	@Column(name = "situacao", nullable = false)
	private String situacao;

	@Column(name = "diaSemana", nullable = false)
	private String diaSemana;

	@OneToOne(targetEntity = Horario.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "horarioCodigo", nullable = false)
	private Horario horarioCodigo;

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAlunoRA() {
		return alunoRA;
	}

	public void setAlunoRA(int alunoRA) {
		this.alunoRA = alunoRA;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public int getHorarioCodigo() {
		return (horarioCodigo != null) ? horarioCodigo.getCodigo() : 0;
	}

	public void setHorarioCodigo(Horario horarioCodigo) {
		this.horarioCodigo = horarioCodigo;
	}

	public int getDisciplinaCodigo() {
		return disciplinaCodigo;
	}

	public void setDisciplinaCodigo(int disciplinaCodigo) {
		this.disciplinaCodigo = disciplinaCodigo;
	}

}
