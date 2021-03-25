package br.com.application.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Ignore;
import org.junit.Test;

import br.application.dao.ClienteDAO;
import br.application.dao.PessoaDAO;
import br.com.application.domain.Cliente;
import br.com.application.domain.Pessoa;

public class ClienteDAOTeste {

	@Test
	@Ignore
	public void salvar() throws ParseException { // throws ParseException - informa que não quero tratar caso dê errado
													// a data.
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		Cliente cliente = new Cliente();
		// cliente.setDataCadastro(new Date()); // seta no banco a data atual no padrão
		// USA
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("22/02/2020"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);

		System.out.println("Cliente Salvo com sucesso.");

	}

	@Test
	@Ignore
	public void buscar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(1L);

		System.out.println(cliente.getPessoa().getNome());
		System.out.println(cliente.getLiberado());
	}

	@Test
	@Ignore
	public void excluir() {

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(3L);

		if (cliente == null) {
			System.out.println("Cliente não encontrado");
		} else {
			clienteDAO.excluir(cliente);
			System.out.println("Cliente excluido com sucesso");
			System.out.println(cliente.getPessoa().getNome());
		}

	}

	@Test
	public void editar() throws ParseException {// throws ParseException - informa que não quero tratar caso dê errado a data.

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(1L);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa= pessoaDAO.buscar(2L);
		
		if (cliente==null) {
			System.out.println("cliente não encontrado");
		}else {
			cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("15/09/2020"));
			cliente.setLiberado(false);
			cliente.setPessoa(pessoa);
			
			clienteDAO.editar(cliente);
		}
		
		
		
		
		
		

	}

}
