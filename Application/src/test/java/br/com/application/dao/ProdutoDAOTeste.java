package br.com.application.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.application.dao.FabricanteDAO;
import br.application.dao.ProdutoDAO;
import br.com.application.domain.Fabricante;
import br.com.application.domain.Produto;

public class ProdutoDAOTeste {

	@Test
	public void salvar() {

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(2L);

		Produto produto = new Produto();
		produto.setDescricao("Desodorante Antitranspirante");
		produto.setFabricante(fabricante);// Chave estrangeira tem que criar o fabricante
		produto.setPreco(new BigDecimal("9.25")); // tem que criar o tipo antes assim como o short quantidade
		produto.setQuantidade(new Short("22"));

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);

		System.out.println("Produto Salvo com Sucesso!");
	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 2L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Não foi possivel encontrar o codigo especificado");
		} else {

			System.out.println("Registro encontrado");
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getQuantidade()
					+ " - " + produto.getPreco() + " - " + produto.getFabricante().getCodigo());
			System.out.println(produto.getFabricante().getDescricao());
		}

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Não foi possivel encontrar o registro");
		} else {

			produtoDAO.excluir(produto);
			System.out.println("Excluido com sucesso");
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao());
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(1L);

		if (produto == null) {
			System.out.println("Não foi possivel encontrar o registro");
		} else {

			produto.setDescricao("Pente");			
			produto.setFabricante(fabricante);// Chave estrangeira tem que criar o fabricante
			produto.setPreco(new BigDecimal(1.44));
			produto.setQuantidade(new Short("3"));
			produtoDAO.editar(produto);
			System.out.println("Registro editado");

			System.out.println(produto.getCodigo() + " - " + produto.getDescricao());
		}

	}
}
