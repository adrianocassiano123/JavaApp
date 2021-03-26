package br.com.application.dao;

import org.hibernate.Session;
import org.junit.Test;

import br.com.application.util.HibernateUtil;

public class HibernateUtilTeste {
	
	@Test
	public void conectar() {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.close();
		HibernateUtil.getSessionFactory().close();
		
	}
}
