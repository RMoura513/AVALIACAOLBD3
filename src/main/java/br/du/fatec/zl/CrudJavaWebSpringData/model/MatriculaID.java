package br.du.fatec.zl.CrudJavaWebSpringData.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class MatriculaID implements Serializable {

	private static final long serialVersionUID = 1L;
	private int c;
	private int codigo;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MatriculaID [c=" + c + ", codigo=" + codigo + ", getC()=" + getC() + ", getCodigo()=" + getCodigo()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
