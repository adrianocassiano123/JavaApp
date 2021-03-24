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
}
