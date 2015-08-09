package daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import database.DatabaseService;
import entities.DatabaseVersion;

public class DatabaseVersionDAO {

	private DatabaseService service;

	public DatabaseVersionDAO(DatabaseService service) {
		this.service = service;
	}

	public DatabaseVersion getDatabaseVersion() {
		DatabaseVersion result = null;
		SessionFactory sessionFactory = service.createSessionFactory();
		if (sessionFactory != null) {

			Session session = sessionFactory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();

				result = (DatabaseVersion) session
						.createSQLQuery("SELECT  * FROM  databaseVersion")
						.addEntity(DatabaseVersion.class).uniqueResult();

				tx.commit();
			} catch (HibernateException e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return result;
	}

	public void setDatabaseVersion(DatabaseVersion version) {
		SessionFactory sessionFactory = service.createSessionFactory();
		if (sessionFactory != null) {

			Session session = sessionFactory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();

				session.update(version);
				
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				session.flush();
				session.close();
			}
		}
	}

}
