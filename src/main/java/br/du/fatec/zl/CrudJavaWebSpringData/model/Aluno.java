package br.du.fatec.zl.CrudJavaWebSpringData.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@Column(name = "RA", nullable = false)
	private int RA;

	@Column(name = "cursoCodigo", nullable = false)
	private int cursoCodigo;

	@Column(name = "turno", length = 10, nullable = false)
	private String turno;

	@Column(name = "CPF", length = 11, nullable = false)
	private String CPF;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "nomeSocial", length = 100, nullable = true)
	private String nomeSocial;

	@Column(name = "dataNascimento", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "tel", nullable = false)
	private int tel;

	@Column(name = "emailPes", length = 100, nullable = false)
	private String emailPes;

	@Column(name = "emailCor", length = 100, nullable = false)
	private String emailCor;

	@Column(name = "dataConclusaoSeg", nullable = false)
	private LocalDate dataConclusaoSeg;

	@Column(name = "instituicaoConclusaoSeg", length = 100, nullable = false)
	private String instituicaoConclusaoSeg;

	@Column(name = "pontuacaoVestibular", nullable = false)
	private float pontuacaoVestibular;

	@Column(name = "posicaoVestibular", nullable = false)
	private int posicaoVestibular;

	@Column(name = "dataIngresso", nullable = false)
	private LocalDate dataIngresso;

	@Column(name = "semestreAnoIngresso", length = 10, nullable = false)
	private String semestreAnoIngresso;

	@Column(name = "semestreAnoLimiteGrad", length = 10, nullable = false)
	private String semestreAnoLimiteGrad;

}
