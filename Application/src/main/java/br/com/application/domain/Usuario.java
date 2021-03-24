package br.com.application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain{
	
	@Column(length=32, nullable=false)
	private String senha;
	
	@Column(nullable=false)
	private Character tipo;
	
	@Column(nullable=false)
	private Boolean ativo;
	
	@JoinColumn(nullable=false)
	@OneToOne
	private Pessoa pessoa;

}
