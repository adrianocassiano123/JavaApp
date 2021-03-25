package br.com.application.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.application.dao.ClienteDAO;
import br.application.dao.FuncionarioDAO;
import br.application.dao.VendaDAO;
import br.com.application.domain.Cliente;
import br.com.application.domain.Funcionario;
import br.com.application.domain.Venda;

public class VendaDAOTeste {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = new Venda();

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(1L);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(2L);

		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());// HH:mm:ss
		venda.setValorTotal(new BigDecimal(15.50));

		vendaDAO.salvar(venda);

	}

	@Test
	@Ignore
	public void buscar() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);

		System.out.println(venda.getCliente().getPessoa().getNome());
		System.out.println(venda.getFuncionario().getPessoa().getNome());

	}

	@Test
	@Ignore
	public void excluir() {

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);

		if (venda == null) {
			System.out.println("Venda não encontrada");

		}else {
			System.out.println("Venda excluída");
			vendaDAO.excluir(venda);
			
			System.out.println("Venda código  -->  "+venda.getCodigo());
		}

		

	}
	
	@Test
	@Ignore
	public void editar() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(2L);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(2L);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(1L);
		
		if (venda==null) {
			System.out.println("Venda Inválida");
		} else {
			venda.setCliente(cliente);
			venda.setFuncionario(funcionario);
			venda.setHorario(new Date());// HH:mm:ss
			venda.setValorTotal(new BigDecimal(9.20));
			
			vendaDAO.editar(venda);
			
			System.out.println("Venda encontrada e editada");
		}
		
		
		
		
	}

}
