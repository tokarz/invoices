package database;

import org.junit.Before;
import org.junit.Test;

public class DbfServiceTest {
	private DbfService sut;

	@Before
	public void setUp() {
		this.sut = new DbfService();
	}

	@Test
	public void thisIsNoTestFool()
	{
		sut.convertDbfToMysql("dbfile");
	}

}
