package database;

import org.junit.Test;

public class DatabaseServiceTest {

	@Test
	public void testSessionFactory() 
	{
		new DatabaseService().createSessionFactory();
	}
	

}
