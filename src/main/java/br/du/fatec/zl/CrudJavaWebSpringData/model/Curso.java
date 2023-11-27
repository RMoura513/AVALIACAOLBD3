package br.du.fatec.zl.CrudJavaWebSpringData.model;

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
@Table(name = "curso")
public class Curso {

	@Id
	@Column(name = "codigo", nullable = false)
	private int codigo;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cargaHoraria", nullable = false)
	private int cargaHoraria;

	@Column(name = "siglaInterna", nullable = false)
	private String siglaInterna;

	@Column(name = "ultimaNotaEnade", nullable = false)
	private int ultimaNotaEnade;

}
