package br.com.application.Bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.application.dao.FabricanteDAO;
import br.com.application.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {

	private Fabricante fabricante;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public void novo() {

		fabricante = new Fabricante();

	}

	public void salvar() {

		try {

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.salvar(fabricante);
			Messages.addGlobalInfo("Fabricante Salvo com Sucesso!");

			novo();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu erro ao tentar salvar Fabricante");
			erro.printStackTrace();
		}
	}

}
