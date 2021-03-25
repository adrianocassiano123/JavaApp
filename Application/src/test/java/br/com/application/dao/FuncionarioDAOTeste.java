package br.com.application.dao;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.application.dao.FuncionarioDAO;
import br.application.dao.PessoaDAO;
import br.com.application.domain.Funcionario;
import br.com.application.domain.Pessoa;

public class FuncionarioDAOTeste {

	@Test
	@Ignore
	public void salvar() {

		Long codigo = 2L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		Funcionario funcionario = new Funcionario();

		funcionario.setCarteiraDeTrabalho("545858548");
		funcionario.setDataAdmissao(new Date());
		funcionario.setPessoa(pessoa);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario);

	}

	@Test
	@Ignore
	public void buscar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);

		if (funcionario == null) {
			System.out.println("Funcionario nao encontrado...");

		}else {
			
			System.out.println("Funcionario encontrado !!!");
			System.out.println("Nome do funcionario    -    "+funcionario.getPessoa().getNome());
			System.out.println("Carteira de trabalho numero    -    "+funcionario.getCarteiraDeTrabalho());
		}

	}
	
	
	
	@Test
	@Ignore
	public void excluir() {
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(3L);
		
		
		if (funcionario==null) {
			System.out.println("Funcionario não encontrado");
			
		}else {
			funcionarioDAO.excluir(funcionario);
			System.out.println("O funcionário - "+funcionario.getPessoa().getNome()+" - Foi excluido");
			
		}
		
	}
	
	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		if (pessoa==null) {
			System.out.println("Pessoa não encontrada");
		}else {
			
			funcionario.setCarteiraDeTrabalho("11111111");
			funcionario.setDataAdmissao(new Date());
			funcionario.setPessoa(pessoa);

			funcionarioDAO.editar(funcionario);
			
		}
		
		
	}
	

}
