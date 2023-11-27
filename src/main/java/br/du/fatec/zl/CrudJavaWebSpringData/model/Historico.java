package br.du.fatec.zl.CrudJavaWebSpringData.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historico")
public class Historico {

	@Id
	@Column(name = "codigo", nullable = false)
	private int codigo;

	@Column(name = "alunoRA", nullable = false)
	private int alunoRA;

	@Column(name = "alunoNome", length = 100, nullable = false)
	private String alunoNome;

	@OneToOne(targetEntity = Curso.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "cursoCodigo", nullable = false)
	private Curso cursoCodigo;

	@Column(name = "cursoNome", length = 100, nullable = false)
	private String cursoNome;

	@OneToOne(targetEntity = Matricula.class, fetch = FetchType.LAZY)
	@JoinColumns(value = { @JoinColumn(name = "matriculaCodigo", nullable = false),
			@JoinColumn(name = "matriculaC", nullable = false) })
	private Matricula matricula;

	@Column(name = "dataMatricula", nullable = false)
	private LocalDate dataMatricula;

	@Column(name = "pontuacaoVestibular", nullable = false)
	private Float pontuacaoVestibular;

	@Column(name = "posicaoVestibular", nullable = false)
	private int posicaoVestibular;

	@Column(name = "qtdAusencias", nullable = true)
	private int qtdAusencias;

	@OneToOne(targetEntity = Disciplina.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "disciplinaCodigo", nullable = true)
	private Disciplina disciplinaCodigo;

	@Column(name = "disciplinaNome", length = 100, nullable = true)
	private String disciplinaNome;

	@Column(name = "professorNome", length = 100, nullable = true)
	private String professorNome;

	@Column(name = "notaFinal", nullable = true)
	private Float notaFinal;

	public String getAlunoNome() {
		return alunoNome;
	}

	public void setAlunoNome(String alunoNome) {
		this.alunoNome = alunoNome;
	}

	public int getCursoCodigo() {
		return (cursoCodigo != null) ? cursoCodigo.getCodigo() : 0;
	}

	public void setCursoCodigo(Curso cursoCodigo) {
		this.cursoCodigo = cursoCodigo;
	}

	public String getCursoNome() {
		return cursoNome;
	}

	public void setCursoNome(String cursoNome) {
		this.cursoNome = cursoNome;
	}

	public int getMatricula() {
		return (matricula != null) ? matricula.getCodigo() : 0;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Float getPontuacaoVestibular() {
		return pontuacaoVestibular;
	}

	public void setPontuacaoVestibular(Float pontuacaoVestibular) {
		this.pontuacaoVestibular = pontuacaoVestibular;
	}

	public int getPosicaoVestibular() {
		return posicaoVestibular;
	}

	public void setPosicaoVestibular(int posicaoVestibular) {
		this.posicaoVestibular = posicaoVestibular;
	}

	public int getQtdAusencias() {
		return qtdAusencias;
	}

	public void setQtdAusencias(int qtdAusencias) {
		this.qtdAusencias = qtdAusencias;
	}

	public int getDisciplinaCodigo() {
		return (disciplinaCodigo != null) ? disciplinaCodigo.getCodigo() : 0;
	}

	public void setDisciplinaCodigo(Disciplina disciplinaCodigo) {
		this.disciplinaCodigo = disciplinaCodigo;
	}

	public String getDisciplinaNome() {
		return disciplinaNome;
	}

	public void setDisciplinaNome(String disciplinaNome) {
		this.disciplinaNome = disciplinaNome;
	}

	public String getProfessorNome() {
		return professorNome;
	}

	public void setProfessorNome(String professorNome) {
		this.professorNome = professorNome;
	}

	public Float getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(Float notaFinal) {
		this.notaFinal = notaFinal;
	}

	public int getAlunoRA() {
		return alunoRA;
	}

	public void setAlunoRA(int alunoRA) {
		this.alunoRA = alunoRA;
	}

}
