package mappers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hexiong.jdbf.JDBFException;
import com.hexiong.jdbf.JDBField;

import entities.DbfColumnValue;
import entities.DbfData;
import entities.Invoices;
import junit.framework.Assert;

public class InvoicesMapperTest {
	private InvoicesMapper sut;

	@Before
	public void setUp() {
		sut = new InvoicesMapper();
	}

	@Test
	public void testMapDbfData() throws JDBFException 
	{
		DbfData data = createData();
		List<Invoices> result = sut.mapDbfData(data);
		
		Assert.assertEquals(1, result.size());
		Assert.assertEquals("date_1", result.get(0).getRokobr());
		Assert.assertEquals("jan", result.get(0).getImieprac());
		Assert.assertEquals("kowalski", result.get(0).getNazwiskoprac());
		Assert.assertEquals(123.45, result.get(0).getAngazplaca());
	}

	private DbfData createData() throws JDBFException {
		DbfData result = new DbfData();
		
		List<List<DbfColumnValue>> someValues = new ArrayList<List<DbfColumnValue>>();
		List<DbfColumnValue> subValues = new ArrayList<DbfColumnValue>();
		DbfColumnValue date = new DbfColumnValue(new JDBField("ROKOBR", 'C', 10, 0), "date_1");
		DbfColumnValue imiePrac = new DbfColumnValue(new JDBField("IMIEPRAC", 'C', 20, 0), "jan");
		DbfColumnValue nazwiskoPrac = new DbfColumnValue(new JDBField("NAZWISKOPR", 'C', 20, 0), "kowalski");
		DbfColumnValue zarobek = new DbfColumnValue(new JDBField("ANGAZPLACA", 'F', 10, 2), 123.45);
		
		subValues.add(date);
		subValues.add(nazwiskoPrac);
		subValues.add(imiePrac);
		subValues.add(zarobek);
		
		someValues.add(subValues);
		
		result.setValues(someValues);
		
		return result;
	}
}
