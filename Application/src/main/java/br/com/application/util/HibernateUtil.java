package br.com.application.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

//	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();
//
//	public static SessionFactory getFabricaDeSessoes() {
//		return fabricaDeSessoes;
//	}
//
//	private static SessionFactory criarFabricaDeSessoes() {
//
//		try {
//			Configuration configuracao = new Configuration().configure();
//			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
//					.build();
//
//			SessionFactory fabrica = configuracao.buildSessionFactory(registro);
//
//			return fabrica;
//		} catch (Throwable ex) {
//			System.err.println("A fabrica de sessões nao pode ser criada." + ex);
//			throw new ExceptionInInitializerError(ex);
//		}
//
//	}

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure();

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			return sessionFactory;
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}