package daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
				result = (User) session.createCriteria(User.class).add( Restrictions.eq("username", name)).add(Restrictions.eq("password", password)).uniqueResult();
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
