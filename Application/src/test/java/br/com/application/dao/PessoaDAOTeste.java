package br.com.application.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.application.dao.CidadeDAO;
import br.application.dao.PessoaDAO;
import br.com.application.domain.Cidade;
import br.com.application.domain.Pessoa;

public class PessoaDAOTeste {

	@Test
	@Ignore
	public void salvar() {

		CidadeDAO cidadeDAO = new CidadeDAO(); // chave estrangeira cidade
		Cidade cidade = cidadeDAO.buscar(1L);

		Pessoa pessoa = new Pessoa();

		pessoa.setNome("Juliete");
		pessoa.setCpf("123.456.789-10");
		pessoa.setRg("1.234.567");
		pessoa.setRua("Rua da felicidade");
		pessoa.setNumero(new Short("20"));
		pessoa.setBairro("Alegria");
		pessoa.setCep("50000-000");
		pessoa.setComplemento("Ao lado da rua C");
		pessoa.setTelefone("81 2020-2121");
		pessoa.setCelular("81 99999-2222");
		pessoa.setEmail("teste@email.com.br");

		pessoa.setCidade(cidade); // faz referencia a cidade FK

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa); // salva a pessoa

		System.out.println("Pessoa Salva com Sucesso!");

	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 2L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Não foi possivel encontrar o codigo especificado");
		} else {

			System.out.println("Registro encontrado");
			System.out.println("CODIGO - " + pessoa.getCodigo());
			System.out.println("NOME - " + pessoa.getNome());
			System.out.println("BAIRRO - " + pessoa.getBairro());
			System.out.println("CIDADE - " + pessoa.getCidade().getNome());
			System.out.println("ESTADO - " + pessoa.getCidade().getEstado().getNome());

		}

	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 2L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Não foi possivel encontrar o registro");
		} else {

			pessoaDAO.excluir(pessoa);
			System.out.println("Excluido com sucesso");
			System.out.println("CODIGO - " + pessoa.getCodigo());
			System.out.println("NOME - " + pessoa.getNome());
			System.out.println("BAIRRO - " + pessoa.getBairro());
			System.out.println("CIDADE - " + pessoa.getCidade().getNome());
			System.out.println("ESTADO - " + pessoa.getCidade().getEstado().getNome());

		}
	}

	@Test
	public void editar() {
		Long codigo = 2L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa= pessoaDAO.buscar(codigo);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(1L);

		if (pessoa == null) {
			System.out.println("Não foi possivel encontrar o registro");
		} else {
			
			pessoa.setCidade(cidade);
			
			pessoa.setNome("Carmem");
			pessoa.setCpf("123.456.888-10");
			pessoa.setRg("1.234.999");
			pessoa.setRua("Rua Reinado");
			pessoa.setNumero(new Short("99"));
			pessoa.setBairro("Pinheiro");
			pessoa.setCep("40000-000");
			pessoa.setComplemento("rua n");
			pessoa.setTelefone("71 2088-2121");
			pessoa.setCelular("81 77777-2222");
			pessoa.setEmail("testar");

			pessoa.setCidade(cidade);
			
			pessoaDAO.editar(pessoa);

			System.out.println("Registro editado");

			}

	}
}
