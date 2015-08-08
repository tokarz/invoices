package daos;

import org.junit.Before;
import org.junit.Test;

import database.DatabaseService;
import entities.Invoices;

public class InvoicesDAOTest {

	private InvoicesDAO sut;
	
	@Before
	public void setUp() throws Exception {
		sut = new InvoicesDAO(new DatabaseService());
	}

	
	@Test
	public void testSetInvoices()
	{
		Invoices invoice = new Invoices();
		invoice.setNazwiskoprac("Tokarz");
		invoice.setImieprac("Zbigniew");
		invoice.setIlo_godz(3.5);
		invoice.setKwota(1.2);
		invoice.setRokobr("2015");
		
		sut.setInvoicesByName(invoice);
	}
}
