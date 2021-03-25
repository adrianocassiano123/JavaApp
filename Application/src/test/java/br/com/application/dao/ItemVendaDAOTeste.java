package br.com.application.dao;

import java.math.BigDecimal;

import org.junit.Test;

import br.application.dao.ItemVendaDAO;
import br.application.dao.ProdutoDAO;
import br.application.dao.VendaDAO;
import br.com.application.domain.ItemVenda;
import br.com.application.domain.Produto;
import br.com.application.domain.Venda;

public class ItemVendaDAOTeste {

	/*
	 * // @Test public void salvar() {
	 * 
	 * VendaDAO vendaDAO = new VendaDAO(); Venda venda = vendaDAO.buscar(2L);
	 * 
	 * ItemVenda itemVenda = new ItemVenda(); produto.setDescricao("Sabonete");
	 * produto.setFabricante(fabricante);// Chave estrangeira tem que criar o
	 * fabricante produto.setPreco(new BigDecimal("1.98")); // tem que criar o tipo
	 * antes assim como o short quantidade produto.setQuantidade(new Short("7"));
	 * 
	 * ProdutoDAO produtoDAO = new ProdutoDAO(); produtoDAO.salvar(produto);
	 * 
	 * System.out.println("Produto Salvo com Sucesso!"); }
	 */

	@Test
	public void salvar() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(1L);

		ItemVenda itemVenda = new ItemVenda();

		itemVenda.setQuantidade(new Short("12"));
		itemVenda.setValorParcial(new BigDecimal("23.8"));
		itemVenda.setProduto(produto);
		itemVenda.setVenda(venda);

		//ItemVenda
		
		//FALTA FAZER INSERT EM PRODUTO

	}

}
