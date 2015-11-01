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
import pl.agropin.mappers.PdfSectionsToJsonMapper;
import pl.agropin.mappers.PrintViewMapper;
import pl.agropin.views.Part;
import pl.agropin.views.PdfSections;
import pl.agropin.views.SalaryView;

@Path("/tableData")
public class DataTablesService {
	private InvoicesDAO invoices;
	private PrintViewMapper printViewMapper;
	private PdfSectionsToJsonMapper pdfSectionsToJsonMapper;

	public DataTablesService() {
		this.invoices = new InvoicesDAO(new DbfService(), new InvoicesMapper());
		this.printViewMapper = new PrintViewMapper();
		this.pdfSectionsToJsonMapper = new PdfSectionsToJsonMapper();
	}

	public DataTablesService(InvoicesDAO invoices, PrintViewMapper printViewMapper, PdfSectionsToJsonMapper mapper) {
		this.invoices = invoices;
		this.printViewMapper = printViewMapper;
		pdfSectionsToJsonMapper = mapper;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTableData(@QueryParam("sessionId") String sessionId, @QueryParam("username") String userName)
			throws IOException, JDBFException {

		List<Invoices> currentInvoices = invoices.getInvoicesByName(userName);
		
		PdfSections pdfSections = printViewMapper.mapInvoicesToPrintViews(currentInvoices);
	
		String jsonResult = pdfSectionsToJsonMapper.map(pdfSections);
		
//
//		int currentLoopIndex = 0;
//		String jsonBig = "{\"data\": [";
//		for (String currentDate : salaryPerDate.keySet()) {
//			SalaryView currentSalaryRow = salaryPerDate.get(currentDate);
//			List<Part> parts = currentSalaryRow.getParts();
//			
//			
//			String currentRow = "{\"date\": \"" + currentDate
//					+ "\"," + "\"title\": \"" + currentSalaryRow.getSummaryTitle() + "\"," + "\"brutto\": \""
//					+ "someBrutto" + "\"," + "\"hours\": \"" + "some houts" + "\"}";
//			if (currentLoopIndex != salaryPerDate.size() - 1) {
//				currentRow += ",";
//			}
//			jsonBig += currentRow;
//			currentLoopIndex++;
//
//		}

//		jsonBig += "]}";

		return jsonResult;
	}

}
