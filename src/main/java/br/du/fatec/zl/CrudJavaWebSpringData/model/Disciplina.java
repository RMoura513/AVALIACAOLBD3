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
@Table(name = "disciplina")
public class Disciplina {

	@Id
	@Column(name = "codigo", nullable = false)
	private int codigo;

	@Column(name = "cursoCodigo", nullable = false)
	private int cursoCodigo;

	@Column(name = "horarioCodigo", nullable = false)
	private int horarioCodigo;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "qtdHorasSemanais", nullable = false)
	private int qtdHorasSemanais;

}
