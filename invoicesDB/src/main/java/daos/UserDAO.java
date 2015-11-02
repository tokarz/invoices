package daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import database.DatabaseService;
import entities.DatabaseVersion;
import entities.Invoices;
import entities.User;

public class UserDAO {
	public DatabaseService service;
	
	public UserDAO(DatabaseService service) {
		this.service = service;
	}
	
	@SuppressWarnings("unchecked")
	public User getUserByNameAndPassword(String name, String password)
	{
		User result = null;
		
		SessionFactory sessionFactory = service.createSessionFactory();
		if (sessionFactory != null) {

			Session session = sessionFactory.openSession();
			try {

				List<Invoices> invoicesForUser = ((List<Invoices>) session
						.createSQLQuery("SELECT  * FROM  paskicrypt WHERE nrprac ='" + name + "' and nazwiskoprac = '" + password + "'")
						.addEntity(Invoices.class).list());
				if(invoicesForUser != null && !invoicesForUser.isEmpty())
				{
					String username = invoicesForUser.get(0).getImieprac();
					result = new User(username, "topSecret");
				}
				
			} catch (HibernateException e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return result;
	}
	
}
