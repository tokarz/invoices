package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import entities.DbfData;
import junit.framework.Assert;

public class DatabaseServiceTest {

	@Test
	public void testJdbc() {
		try {
			Class.forName("jstels.jdbc.dbf.DBFDriver2");

			// create a connection. The first command line parameter is assumed
			// to
			// be the directory in which the .dbf files are held
			Connection conn = DriverManager.getConnection("jdbc:jstels:dbf:" + ".");

			// create a Statement object to execute the query with
			Statement stmt = conn.createStatement();

			// execute a query
			ResultSet rs = stmt.executeQuery("SELECT count(*) from \"c:/development/dbf/paskicrypt.dbf\" WHERE NRPRAC=11100");

			while (rs.next()) {
				for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {
					long result = (long) rs.getObject(j);
					Assert.assertEquals(2561, result);
				}
				System.out.println();
			}

			// close the objects
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testDbfReader() {
		DbfService service = new DbfService();
		
		DbfData record = service.getDbfDataByNameCloseStream("paskicrypt.dbf", "NRPRAC", "111000");

		Assert.assertNotNull(record);
		Assert.assertEquals(2561, record.getValues().size());
		
	}

}
