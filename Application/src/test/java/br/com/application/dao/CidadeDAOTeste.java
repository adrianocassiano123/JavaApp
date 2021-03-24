package br.com.application.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.application.dao.CidadeDAO;
import br.application.dao.EstadoDAO;
import br.com.application.domain.Cidade;
import br.com.application.domain.Estado;

public class CidadeDAOTeste {

	@Test
	@Ignore
	public void salvar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(2L);
		Cidade cidade = new Cidade();

		if (cidade == null || estado == null) {
			System.out.println("não foi possivel encontrar dado");
		} else {
			cidade.setNome("Rio de Janeiro");
			cidade.setEstado(estado);

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.salvar(cidade);
		}

	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();

		for (Cidade cidade : resultado) {
			System.out.println("Código : " + cidade.getCodigo() + "    Nome:   " + cidade.getNome()
					+ " Código Estado:   " + cidade.getEstado().getCodigo() + "  Sigla Estado:   "
					+ cidade.getEstado().getSigla() + "  Nome Estado:   " + cidade.getEstado().getNome());
		}

	}

	@Test
	//@Ignore
	public void buscar() {
		Long codigo = 2L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);

		System.out.println("Código : " + cidade.getCodigo() + "    Nome:   " + cidade.getNome() + " Código Estado:   "
				+ cidade.getEstado().getCodigo() + "  Sigla Estado:   " + cidade.getEstado().getSigla()
				+ "  Nome Estado:   " + cidade.getEstado().getNome());

	}
	
	//@Test
	public void excluir() {
		Long codigo = 6L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
			
		if (cidade == null) {
			System.out.println("Cidade não enontrada");
			
		}else {
			cidadeDAO.excluir(cidade);
			System.out.println("Cidade Removida:   ");
			System.out.println("Código : " + cidade.getCodigo() + "    Nome:   " + cidade.getNome() + " Código Estado:   "
					+ cidade.getEstado().getCodigo() + "  Sigla Estado:   " + cidade.getEstado().getSigla()
					+ "  Nome Estado:   " + cidade.getEstado().getNome());
		}
	}

}
