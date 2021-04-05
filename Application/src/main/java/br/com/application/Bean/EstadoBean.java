package br.com.application.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.application.dao.EstadoDAO;
import br.com.application.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	private Estado estado;

	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct // Chamado após o construtor
	public void listar() {
		try {

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar listar estado");
			erro.printStackTrace();
		}
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
		try {

			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);

			estado = new Estado();
			estados= estadoDAO.listar();

			novo();
			// estados = estadoDAO.listar();

			Messages.addGlobalInfo("Estado salvo com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar salvar estado");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) { // parametro é para capturar coisas que são mandadas
		
		try {			
		
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.excluir(estado);
		estados= estadoDAO.listar();
		
		Messages.addGlobalInfo("Estado Removido com Sucesso");
		
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o estado");
			erro.printStackTrace();
		}

	}
	
	
	public void editar(ActionEvent evento) {
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
	}
}
