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
@Table(name = "chamada")
public class Chamada {

	@Id
	@Column(name = "codigo", nullable = false)
	private int codigo;

	@Column(name = "alunoRA", nullable = false)
	private int alunoRA;

	@Column(name = "alunoNome", length = 100, nullable = false)
	private String alunoNome;

	@Column(name = "cursoCodigo", nullable = false)
	private int cursoCodigo;

	@Column(name = "disciplinaCodigo", nullable = false)
	private int disciplinaCodigo;

	@Column(name = "matriculaCodigo", nullable = false)
	private int matriculaCodigo;

	@Column(name = "matriculaC", nullable = false)
	private int matriculaC;

	@Column(name = "diaSemana", length = 15, nullable = false)
	private String diaSemana;

	@Column(name = "ausencia", nullable = true)
	private int ausencia;

	@Column(name = "dataChamada", nullable = false)
	private LocalDate dataChamada;

}