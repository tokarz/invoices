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

@Path("/tableData")
public class DataTablesService {
	private InvoicesDAO invoices;

	public DataTablesService() {
		this.invoices = new InvoicesDAO(new DbfService(), new InvoicesMapper());
	}

	public DataTablesService(InvoicesDAO invoices) {
		this.invoices = invoices;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTableData(@QueryParam("sessionId") String sessionId, @QueryParam("username") String userName)
			throws IOException, JDBFException {
		String jsonBig = "{\"data\": [";

		List<Invoices> currentInvoices = invoices.getInvoicesByName(userName);

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
