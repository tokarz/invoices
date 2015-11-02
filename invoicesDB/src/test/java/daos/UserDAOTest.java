package daos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import database.DatabaseService;
import entities.User;

public class UserDAOTest {
	private UserDAO sut;

	@Before
	public void setUp() throws Exception {
		DatabaseService service = new DatabaseService();
		sut = new UserDAO(service);
	}

	@Test
	public void testGetUser() {
		User userByNameAndPassword = sut.getUserByNameAndPassword("toki", "toki");
		Assert.assertNotNull(userByNameAndPassword);
	}
}
