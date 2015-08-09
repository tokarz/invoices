package daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import database.DatabaseService;
import entities.User;

public class UserDAO {
	private DatabaseService databaseService;

	public UserDAO(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}
	
	public User getUserByNameAndPassword(String name, String password)
	{
		User result = null;
		SessionFactory sessionFactory = databaseService.createSessionFactory();
		if (sessionFactory != null) {

			Session session = sessionFactory.openSession();
			try {
				String query = "Select * from users where username = \"" + name + "\" and password = \"" + password + "\";";
				
				
				Object resultObj = session.createSQLQuery(query).uniqueResult();
				result = (User)resultObj;
			} catch (HibernateException e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return result;
	}
	
	public void setUser(User user)
	{
		SessionFactory sessionFactory = databaseService.createSessionFactory();
		if (sessionFactory != null) {

			Session session = sessionFactory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(user);
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
