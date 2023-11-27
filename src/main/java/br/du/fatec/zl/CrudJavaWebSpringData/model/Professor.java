package br.du.fatec.zl.CrudJavaWebSpringData.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "professor")
public class Professor {

    @Id
    @Column(name = "codigo", nullable = false)
    private int codigo;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "disciplinaCodigo", nullable = false)
    private int disciplinaCodigo;


}

