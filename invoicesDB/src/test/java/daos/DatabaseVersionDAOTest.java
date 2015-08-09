package daos;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import database.DatabaseService;
import entities.DatabaseVersion;


public class DatabaseVersionDAOTest {

	private DatabaseVersionDAO sut;
	
	@Before
	public void setUp() throws Exception 
	{
		sut = new DatabaseVersionDAO(new DatabaseService());
	}
	
	@Test
	public void testGetDatabaseVersion()
	{
		DatabaseVersion databaseVersionByName = sut.getDatabaseVersion();
		Assert.assertEquals(databaseVersionByName.getId(), 1);
		Assert.assertEquals(databaseVersionByName.getVersion(), "0.2");
	}
	
	@Test
	public void testSetDatabaseVersion()
	{
		DatabaseVersion version = new DatabaseVersion();
		version.setId(1);
		version.setVersion("0.2");
		sut.setDatabaseVersion(version);
		
		DatabaseVersion databaseVersionByName = sut.getDatabaseVersion();
		Assert.assertEquals(databaseVersionByName.getId(), 1);
		Assert.assertEquals(databaseVersionByName.getVersion(), "0.2");
	}

}
