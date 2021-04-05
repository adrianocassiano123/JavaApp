package br.com.application.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


//Classe geérica que vai ser utilizada pelas outras e não vai ser uma tabela
@SuppressWarnings("serial") //Ignora o warns do tipo serial nessa classe
@MappedSuperclass // anotação para dizer que não corresponde a uma tabela// Forma de compartilhar a chave primária
public class GenericDomain implements Serializable { 
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)//Auto o proprio banco gerencia
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
	    return String.format("%s[codigo=%d]", getClass().getSimpleName(), getCodigo());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericDomain other = (GenericDomain) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}
