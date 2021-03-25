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

	//@Test
	public void salvar() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(3L);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(4L);

		ItemVenda itemVenda = new ItemVenda();

		itemVenda.setQuantidade(new Short("2"));
		itemVenda.setValorParcial(new BigDecimal("12.5"));
		itemVenda.setProduto(produto);
		itemVenda.setVenda(venda);

		ItemVendaDAO itemvendaDao = new ItemVendaDAO();
		itemvendaDao.salvar(itemVenda);

	}

	
	@Test
	public void buscar() {
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(2L);
		
		if (itemVenda==null) {
			System.out.println("Item não encontrado");
		} else {
			System.out.println("Item venda encontrado");
			System.out.println("Código do Item - "+itemVenda.getCodigo());
			System.out.println("Nome Item - "+itemVenda.getProduto().getDescricao());
		}
	}
	
	//@Test
	public void excluir() {
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(4L);
		
		itemVendaDAO.excluir(itemVenda);
	}
	
	//@Test
	public void editar() {
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(3L);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(4L);
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(3L);

		itemVenda.setQuantidade(new Short("8"));
		itemVenda.setValorParcial(new BigDecimal("11.11"));
		itemVenda.setProduto(produto);
		itemVenda.setVenda(venda);

		ItemVendaDAO itemvendaDao = new ItemVendaDAO();
		itemvendaDao.editar(itemVenda);
		
	}
	
}
