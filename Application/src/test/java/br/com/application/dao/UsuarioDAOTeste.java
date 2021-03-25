package br.com.application.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.application.dao.PessoaDAO;
import br.application.dao.UsuarioDAO;
import br.com.application.domain.Pessoa;
import br.com.application.domain.Usuario;

public class UsuarioDAOTeste {
	
	@Test
	@Ignore
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(false);
		usuario.setTipo('A');
		usuario.setSenha("88888");
		usuario.setPessoa(pessoa);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		System.out.println("Usuário salvo com sucesso");
		
		
		
		
	}
	
	@Test
	@Ignore
	public void buscar() {

		Long codigo = 3L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		if (usuario == null) {
			System.out.println("Não foi possivel encontrar o codigo especificado");
		} else {

			System.out.println("Registro encontrado");
			System.out.println("Ativo? - "+usuario.getAtivo());
			System.out.println(usuario.getPessoa().getNome());
			
			
			
		}

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		if (usuario == null) {
			System.out.println("Não foi possivel encontrar o registro");
		} else {

			usuarioDAO.excluir(usuario);
			System.out.println("Excluido com sucesso");
			System.out.println(usuario.getPessoa().getNome());
			System.out.println(usuario.getTipo());
		}
	}

	@Test
	public void editar() {
		
		Long codigo = 1L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);

		if (usuario == null) {
			System.out.println("Não foi possivel encontrar o usuario");
		} else {
			usuario.setAtivo(false);
			usuario.setTipo('C');
			usuario.setSenha("99999");
			usuario.setPessoa(pessoa);
			
			usuarioDAO.editar(usuario);
			
			System.out.println("pessoa editada");

			
		}

	}
}



