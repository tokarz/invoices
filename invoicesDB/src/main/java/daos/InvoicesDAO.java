package daos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hexiong.jdbf.JDBFException;

import database.DbfService;
import entities.DbfData;
import entities.Invoices;
import mappers.InvoicesMapper;

public class InvoicesDAO {
	private final DbfService service;
	private final InvoicesMapper invoicesMapper;
	
	public InvoicesDAO(DbfService service, InvoicesMapper invoicesMapper) {
		this.service = service;
		this.invoicesMapper = invoicesMapper;
	}

	public List<Invoices> getInvoicesByName(String name) throws IOException, JDBFException {
		List<Invoices> result = new ArrayList<Invoices>();
		DbfData messagesByName = service.getDbfDataByNameCloseStream("dbfile", "NRPRAC",name);
		
		result = invoicesMapper.mapDbfData(messagesByName);
		
		return result;
	}

}
