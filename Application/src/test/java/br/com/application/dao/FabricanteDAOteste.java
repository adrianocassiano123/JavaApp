package br.com.application.dao;

//import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.application.dao.FabricanteDAO;
import br.com.application.domain.Fabricante;

public class FabricanteDAOteste {

	@Test
	@Ignore
	public void salvar() {

		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Unilever");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);

	}

	/*
	 * @Test public void listar() { FabricanteDAO fabricanteDAO = new
	 * FabricanteDAO(); List<Fabricante> resultado = fabricanteDAO.listar();
	 * 
	 * System.out.println("Total de Registros encontrados" + "  -   " +
	 * resultado.size());
	 * 
	 * for (Fabricante fabricante : resultado) {
	 * System.out.println(fabricante.getCodigo() + " - " +
	 * fabricante.getDescricao()); }
	 * 
	 * }
	 */

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 1L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Não foi possivel encontrar o codigo especificado");
		} else {

			System.out.println("Registro encontrado");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Não foi possivel encontrar o registro");
		} else {

			fabricanteDAO.excluir(fabricante);
			System.out.println("Excluido com sucesso");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	public void editar() {
		Long codigo = 1L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Não foi possivel encontrar o registro");
		} else {

			fabricante.setDescricao("J&J");
			fabricanteDAO.editar(fabricante);
			System.out.println("Registro editado");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}

	}

}
