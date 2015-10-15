package pl.agropin.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
import pl.agropin.views.SalaryView;

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

		List<Invoices> currentInvoices = invoices.getInvoicesByName(userName);
		Map<String, SalaryView> salaryPerDate = printViewMapper.mapInvoicesToPrintViews(currentInvoices);

		int currentLoopIndex = 0;
		String jsonBig = "{\"data\": [";
		for (String currentDate : salaryPerDate.keySet()) {
			SalaryView currentSalaryRow = salaryPerDate.get(currentDate);
			String currentRow = "{\"select\": \"" + "false" + "\"," + "\"date\": \"" + currentSalaryRow.getDate()
					+ "\"," + "\"netto\": \"" + currentSalaryRow.getMoneyNetto() + "\"," + "\"brutto\": \""
					+ currentSalaryRow.getMoneyBrutto() + "\"," + "\"hours\": \"" + currentSalaryRow.getHours() + "\"}";
			if (currentLoopIndex != salaryPerDate.size() - 1) {
				currentRow += ",";
			}
			jsonBig += currentRow;
			currentLoopIndex++;

		}

		jsonBig += "]}";

		return jsonBig;
	}

}
