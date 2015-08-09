package daos;

import java.util.ArrayList;
import java.util.List;

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

	@SuppressWarnings("unchecked")
	public List<Invoices> getInvoicesByName(String name) {
		List<Invoices> result = new ArrayList<Invoices>();
		SessionFactory sessionFactory = service.createSessionFactory();
		if (sessionFactory != null) {

			Session session = sessionFactory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();

				result = (List<Invoices>) session
						.createSQLQuery(
								"SELECT  * FROM  lcZbiorCel where nazwiskoprac = \""+ name +"\""
										).addEntity(Invoices.class)
						.list();

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
