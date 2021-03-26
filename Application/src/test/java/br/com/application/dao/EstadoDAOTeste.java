package br.com.application.dao;

//import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.application.dao.EstadoDAO;
import br.com.application.domain.Estado;

public class EstadoDAOTeste {

	@Test
	//@Ignore // serve para ignorar esse teste
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	/*
	 * @Test
	 * 
	 * @Ignore public void listar() { EstadoDAO estadoDAO = new EstadoDAO();
	 * List<Estado> resultado = estadoDAO.listar();
	 * 
	 * System.out.println("Total de Registros encontrados" + "  -   " +
	 * resultado.size());
	 * 
	 * for (Estado estado : resultado) { System.out.println(estado.getCodigo() +
	 * " - " + estado.getSigla() + "-" + estado.getNome()); }
	 * 
	 * }
	 * 
	 */

	//@Test
	//@Ignore
	public void buscar() {

		Long codigo = 2L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Não foi possivel encontrar o codigo especificado");
		} else {

			System.out.println("Encontrado");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + "-" + estado.getNome());
		}

	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 6L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Não foi possivel encontrar o codigo especificado");
		} else {

			estadoDAO.excluir(estado);
			System.out.println("Registro encontrado");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + "-" + estado.getNome());
		}

	}

	//@Test
	public void editar() {
		Long codigo = 5L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);


		if (estado == null) {
			System.out.println("Não foi possivel encontrar o codigo especificado");
		} else {

			estado.setNome("Paraná");
			estado.setSigla("PR");
			estadoDAO.editar(estado);
			System.out.println("Registro editado");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + "-" + estado.getNome());
		}

	}

}
