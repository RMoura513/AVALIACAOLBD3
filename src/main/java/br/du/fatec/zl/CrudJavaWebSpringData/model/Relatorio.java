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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "relatorios")
public class Relatorio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "codigo", nullable = false)
	private int codigo;
	
	@Column(name = "alunoRA", nullable = false)
	private int alunoRA;
	
	@Column(name = "alunoNome", nullable = true)
	private String alunoNome;
	
	@Column(name = "disciplinaNome", nullable = false)
	private String disciplinaNome;
	
	@Column(name = "qtdAusenciasNaSemana", nullable = false)
	private int qtdAusenciasNaSemana;
	
	@Column(name = "totalAusencias", nullable = false)
	private int totalAusencias;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	
}
