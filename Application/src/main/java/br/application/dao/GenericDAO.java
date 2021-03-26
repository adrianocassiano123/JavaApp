package br.application.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import br.com.application.util.HibernateUtil;

public class GenericDAO<Entidade> {

	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {

		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); // capturar uma sessao aberta
		//Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); // capturar uma sessao aberta
		Transaction transacao = null; // capturar um transaction

		try {
			transacao = sessao.beginTransaction(); // para criar uma transacao precisa de uma sessao
			sessao.save(entidade);
			transacao.commit();

		} catch (RuntimeException erro) { // caso dê alguma coisa errada na transacao temos que desfazer( roollbak) no
											// catch

			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;

		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {

			Criteria consulta = sessao.createCriteria(classe);// fazer listagem = forma orientada a objetos
			List<Entidade> resultado = consulta.list();// variavel para guardar o
			return resultado;

		} catch (Exception erro) {
			throw erro;
		} finally {
			sessao.close();
		}

	}

	public Entidade buscar(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {

			Criteria consulta = sessao.createCriteria(classe);// fazer listagem = forma orientada a objetos
			consulta.add(Restrictions.idEq(codigo)); // busca a restricao WHERE e compara com a chave primaria
			@SuppressWarnings("unchecked")
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;

			// List<Entidade> resultado = consulta.list();// variavel para guardar o
			// resultado

		} catch (Exception erro) {
			throw erro;
		} finally {
			sessao.close();
		}

	}

	public void excluir(Entidade entidade) {

		Session sessao = HibernateUtil.getSessionFactory().openSession(); // capturar uma sessao aberta
		Transaction transacao = null; // capturar um transaction

		try {
			transacao = sessao.beginTransaction(); // para criar uma transacao precisa de uma sessao
			sessao.delete(entidade); // deleta
			transacao.commit();

		} catch (RuntimeException erro) { // caso dê alguma coisa errada na transacao temos que desfazer( roollbak) no
											// catch

			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;

		} finally {
			sessao.close();
		}

	}

	public void editar(Entidade entidade) {

		Session sessao = HibernateUtil.getSessionFactory().openSession(); // capturar uma sessao aberta
		Transaction transacao = null; // capturar um transaction

		try {
			transacao = sessao.beginTransaction(); // para criar uma transacao precisa de uma sessao
			sessao.update(entidade); // deleta
			transacao.commit();

		} catch (RuntimeException erro) { // caso dê alguma coisa errada na transacao temos que desfazer( roollbak) no
											// catch

			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;

		} finally {
			sessao.close();
		}

	}
	
	public void merge(Entidade entidade) {

		Session sessao = HibernateUtil.getSessionFactory().openSession(); // capturar uma sessao aberta
		Transaction transacao = null; // capturar um transaction

		try {
			transacao = sessao.beginTransaction(); // para criar uma transacao precisa de uma sessao
			sessao.merge(entidade);
			transacao.commit();

		} catch (RuntimeException erro) { // caso dê alguma coisa errada na transacao temos que desfazer( roollbak) no
											// catch

			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;

		} finally {
			sessao.close();
		}

	}

}
