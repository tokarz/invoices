package database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entities.Invoices;

public class DatabaseService {
	public SessionFactory createSessionFactory() {
		SessionFactory sessionFactory = null;

		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Invoices.class);
//			configuration.addAnnotatedClass(DatabaseVersion.class);
//			configuration.addAnnotatedClass(User.class);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return sessionFactory;
	}
}
