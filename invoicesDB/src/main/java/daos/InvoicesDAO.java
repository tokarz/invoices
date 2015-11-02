package daos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexiong.jdbf.JDBFException;

import database.DatabaseService;
import database.DbfService;
import entities.DatabaseVersion;
import entities.DbfData;
import entities.Invoices;
import mappers.InvoicesMapper;

public class InvoicesDAO {
	// private final DbfService service;
	private final DatabaseService service;

	public InvoicesDAO(DatabaseService service) {
		this.service = service;
	}

	@SuppressWarnings("unchecked")
	public List<Invoices> getInvoicesByName(String name) throws IOException, JDBFException {
		List<Invoices> result = null;
		SessionFactory sessionFactory = service.createSessionFactory();
		if (sessionFactory != null) {

			Session session = sessionFactory.openSession();
			try {

				result = ((List<Invoices>) session
						.createSQLQuery("SELECT  * FROM  paskicrypt WHERE nrprac ='" + name + "'")
						.addEntity(Invoices.class).list());

			} catch (HibernateException e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return result;
	}

}
