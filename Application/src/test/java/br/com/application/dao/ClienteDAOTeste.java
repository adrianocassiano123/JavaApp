package br.com.application.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import br.application.dao.ClienteDAO;
import br.application.dao.PessoaDAO;
import br.com.application.domain.Cliente;
import br.com.application.domain.Pessoa;

public class ClienteDAOTeste {

	@Test
	public void salvar() throws ParseException { //throws ParseException - informa que não quero tratar caso dê errado a data.
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		Cliente cliente = new Cliente();
		//cliente.setDataCadastro(new Date()); // seta no banco a data atual no padrão USA
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("10/02/2020"));
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		
		System.out.println("Cliente Salvo com sucesso.");

	}
}
