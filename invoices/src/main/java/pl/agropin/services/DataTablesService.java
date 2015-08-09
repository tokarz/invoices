package pl.agropin.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import daos.InvoicesDAO;
import database.DatabaseService;
import entities.Invoices;

@Path("/tableData")
public class DataTablesService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTableData(String sessionId, String userName,
			String password) {
		String jsonBig = "{\"data\": [";
		InvoicesDAO invoices = new InvoicesDAO(new DatabaseService());
		List<Invoices> currentInvoices = invoices.getInvoicesByName("Tokarz");

		int currentLoopIndex = 0;
		for (Invoices currentInvoice : currentInvoices) {
			String currentRow = "{\"select\": \"" + "false" + "\","
					+ "\"date\": \"" + currentInvoice.getRokpod() + "\","
					+ "\"fname\": \"" + currentInvoice.getImieprac() + "\","
					+ "\"lname\": \"" + currentInvoice.getNazwiskoprac()
					+ "\"," + "\"salary\": \"" + currentInvoice.getKwota()
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
