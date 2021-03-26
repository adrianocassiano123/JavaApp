package br.com.application.Bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;

import br.application.dao.EstadoDAO;
import br.com.application.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {
//		String texto= "Programação Web com Java";
//		FacesMessage mensagem= new FacesMessage(FacesMessage.SEVERITY_INFO,texto,texto);// primeiro texto é o erro resumido e o segundo é o detalhado
//		
//		FacesContext contexto = FacesContext.getCurrentInstance();
//		
//		contexto.addMessage(null, mensagem);

		Messages.addGlobalInfo(estado.getNome() + "    E   " + estado.getSigla());

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);

	}
}
