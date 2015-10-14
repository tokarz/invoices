package pl.agropin.services;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hexiong.jdbf.JDBFException;

import daos.InvoicesDAO;
import database.DbfService;
import entities.Invoices;
import mappers.InvoicesMapper;
import pl.agropin.mappers.PrintViewMapper;
import pl.agropin.views.PrintView;

@Path("/tableData")
public class DataTablesService {
	private InvoicesDAO invoices;
	private PrintViewMapper printViewMapper;

	public DataTablesService() {
		this.invoices = new InvoicesDAO(new DbfService(), new InvoicesMapper());
		this.printViewMapper = new PrintViewMapper();
	}

	public DataTablesService(InvoicesDAO invoices, PrintViewMapper printViewMapper) {
		this.invoices = invoices;
		this.printViewMapper = printViewMapper;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTableData(@QueryParam("sessionId") String sessionId, @QueryParam("username") String userName)
			throws IOException, JDBFException {
		
		
		String jsonBig = "{\"data\": [";

		List<Invoices> currentInvoices = invoices.getInvoicesByName(userName);
		List<PrintView> printView = printViewMapper.mapInvoicesToPrintViews(currentInvoices);

		int currentLoopIndex = 0;
		for (Invoices currentInvoice : currentInvoices) {
			String currentRow = "{\"select\": \"" + "false" + "\"," + "\"date\": \"" + currentInvoice.getRokpod()
					+ "\"," + "\"fname\": \"" + currentInvoice.getImieprac() + "\"," + "\"lname\": \""
					+ currentInvoice.getNazwiskoprac() + "\"," + "\"salary\": \"" + currentInvoice.getAngazplaca()
					+ "\"}";
			if (currentLoopIndex != currentInvoices.size() - 1) {
				currentRow += ",";
			}
			jsonBig += currentRow;
			currentLoopIndex++;
		}

		jsonBig += "]}";

		return jsonBig;
	}

}
