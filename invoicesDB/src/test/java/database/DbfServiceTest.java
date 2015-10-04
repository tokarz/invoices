package database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;

import entities.DbfData;
import junit.framework.Assert;

public class DbfServiceTest {
	private DbfService sut;

	@Before
	public void setUp() {
		this.sut = new DbfService();
	}

	@Test
	public void getDbfDataByNameCloseStream() {
		DbfData result = sut.getDbfDataByNameCloseStream("paskicrypt.dbf", "NRPRAC", "00001");

		Assert.assertEquals(44, result.getColumns().size());
		Assert.assertEquals(24, result.getValues().size());

	}

	@Test
	public void getDbfDataByNameCloseStream_FieldNotFound() {
		DbfData result = sut.getDbfDataByNameCloseStream("paskicrypt.dbf", "SOME_NOT_EXISTING_FIELD", "00001");

		Assert.assertEquals(44, result.getColumns().size());
		Assert.assertEquals(0, result.getValues().size());

	}

}
