package database;

import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Test;

import junit.framework.Assert;

public class DbfConfigurationTest {

	@Test
	public void testGetDbPath()  {
		try {
			DbFileInfo dbPath = DbfConfiguration.getDbPath();
			Assert.assertEquals("c:/development/dbf/", dbPath.folderPath);
			Assert.assertEquals(Charset.forName("UTF-8"), dbPath.charset);
		} catch (IOException e) {
			Assert.fail();
		}
		
	}
	
}
