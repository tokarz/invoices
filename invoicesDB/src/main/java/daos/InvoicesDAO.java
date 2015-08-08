package daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import database.DatabaseService;
import entities.DatabaseVersion;
import entities.Invoices;

public class InvoicesDAO {
	private DatabaseService service;

	public InvoicesDAO(DatabaseService service) {
		this.service = service;
	}

	public Invoices getInvoicesByName(String name) {
		Invoices result = null;
		SessionFactory sessionFactory = service.createSessionFactory();
		if (sessionFactory != null) {

			Session session = sessionFactory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();

				result = (Invoices) session
						.createSQLQuery(
								"SELECT  * FROM  lcZbiorCel where nazwiskoprac = "
										+ name).addEntity(Invoices.class)
						.uniqueResult();

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
	
	public void setInvoicesByName(Invoices invoice) {
		SessionFactory sessionFactory = service.createSessionFactory();
		if (sessionFactory != null) {

			Session session = sessionFactory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();

				session.save(invoice);

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
	}

}
