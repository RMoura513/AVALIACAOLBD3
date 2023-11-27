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
@Table(name = "horario")
public class Horario {

	@Id
	@Column(name = "codigo", nullable = false)
	private int codigo;
	
	@Column(name = "horaInicio", length = 5, nullable = false)
	private String horaInicio;
	
	@Column(name = "horaFim", length = 5, nullable = false)
	private String horaFim;
	
	@Column(name = "qtdAula", nullable = false)
	private int qtdAula;

}
