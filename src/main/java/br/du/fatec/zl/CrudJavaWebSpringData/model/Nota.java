package br.du.fatec.zl.CrudJavaWebSpringData.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notas")
public class Nota {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "codigo", nullable = false)
	private int codigo;
	
	@Column(name = "alunoRA", nullable = false)
	private int alunoRA;
	
	@Column(name = "avaliacaoCodigo", nullable = false)
	private int avaliacaoCodigo;
	
	@Column(name = "disciplinaCodigo", nullable = false)
	private int disciplinaCodigo;
	
	@Column(name = "notaP1", nullable = true)
	private float notaP1;
	
	@Column(name = "notaP2", nullable = true)
	private float notaP2;
	
	@Column(name = "notaP3", nullable = true)
	private float notaP3;
	
	@Column(name = "notaT", nullable = true)
	private float notaT;
	
	@Column(name = "notaA", nullable = true)
	private float notaA;
	
	@Column(name = "notaM", nullable = true)
	private float notaM;
	
	
	
}
