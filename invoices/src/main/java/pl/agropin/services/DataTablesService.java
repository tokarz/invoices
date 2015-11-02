package pl.agropin.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.hexiong.jdbf.JDBFException;

import daos.InvoicesDAO;
import database.DatabaseService;
import database.DbfService;
import entities.Invoices;
import mappers.InvoicesMapper;
import pl.agropin.mappers.PdfSectionsToJsonMapper;
import pl.agropin.mappers.PrintViewMapper;
import pl.agropin.mappers.SalaryViewMapper;
import pl.agropin.views.PdfSections;
import pl.agropin.views.TableRowView;

@Path("/tableData")
public class DataTablesService {
	private InvoicesDAO invoices;
	private PrintViewMapper printViewMapper;
	private PdfSectionsToJsonMapper pdfSectionsToJsonMapper;
	private SalaryViewMapper salaryViewMapper;

	public DataTablesService() {
		this.invoices = new InvoicesDAO(new DatabaseService());
		this.printViewMapper = new PrintViewMapper();
		this.pdfSectionsToJsonMapper = new PdfSectionsToJsonMapper();
		this.salaryViewMapper = new SalaryViewMapper();
	}

	public DataTablesService(InvoicesDAO invoices, PrintViewMapper printViewMapper, PdfSectionsToJsonMapper mapper,
			SalaryViewMapper salaryMapper) {
		this.invoices = invoices;
		this.printViewMapper = printViewMapper;
		pdfSectionsToJsonMapper = mapper;
		salaryViewMapper = salaryMapper;
	}

	@Path("/tableContents")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTableData(@QueryParam("sessionId") String sessionId, @QueryParam("username") String userName)
			throws IOException, JDBFException {

		List<Invoices> currentInvoices = invoices.getInvoicesByName(userName);
		Map<String, TableRowView> salaryPerDate = salaryViewMapper.mapInvoicesToSalaryView(currentInvoices);
		List<String> sortedKeys = new ArrayList<String>(salaryPerDate.keySet());
		Collections.sort(sortedKeys);

		int currentLoopIndex = 0;
		String jsonBig = "{\"data\": [";
		for (String currentDate : sortedKeys) {
			TableRowView currentTableRow = salaryPerDate.get(currentDate);

			String currentRow = "{\"date\": \"" + currentTableRow.getDate() + "\"," + "\"brutto\": \""
					+ currentTableRow.getBrutto() + "\"," + "\"netto\": \"" + currentTableRow.getNetto() + "\","
					+ "\"hours\": \"" + currentTableRow.getHours() + "\"}";
			if (currentLoopIndex != salaryPerDate.size() - 1) {
				currentRow += ",";
			}
			jsonBig += currentRow;
			currentLoopIndex++;
		}

		jsonBig += "]}";

		return jsonBig;
	}

	@Path("/pdfContents")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getPdfContents(@QueryParam("sessionId") String sessionId, @QueryParam("username") String userName, @QueryParam("date") String date)
			throws IOException, JDBFException {

		List<Invoices> invoicesForDate = new ArrayList<Invoices>();
		List<Invoices> currentInvoices = invoices.getInvoicesByName(userName);
		for (Invoices invoices : currentInvoices) {
			if((invoices.getRokobr() + "." + invoices.getMcobr()).equals(date))
			{
				invoicesForDate.add(invoices);
			}
		}
		
		PdfSections pdfSections = printViewMapper.mapInvoicesToPdfSections(invoicesForDate);

		String jsonResult = pdfSectionsToJsonMapper.map(pdfSections);
		try {
			JSONObject jsonObj = new JSONObject(jsonResult);
			return jsonObj.toString();
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		
		return "";
	}

}
