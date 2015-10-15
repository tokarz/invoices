package pl.agropin.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.xml.bind.v2.runtime.unmarshaller.InterningXmlVisitor;

import entities.Invoices;
import pl.agropin.views.PrintView;
import pl.agropin.views.SalaryView;

public class PrintViewMapper {

	public Map<String, SalaryView> mapInvoicesToPrintViews(List<Invoices> currentInvoices) {
		Map<String, SalaryView> results = new HashMap<String, SalaryView>();
		
		SalaryView salaryView = null;
		for (Invoices invoices : currentInvoices) {
			String currentDate = invoices.getRokobr() + "." + invoices.getMcobr();
			if(results.containsKey(currentDate)) 
			{
				salaryView = results.get(currentDate);
			}
			else {
				salaryView = new SalaryView();
			}
			
			if (invoices.getSymb_sk().equals("001")) {
				salaryView.setHours(invoices.getIlo_godz().toString());
				salaryView.setMoneyNetto(invoices.getKwota().toString());
			}
			if (invoices.getSymb_sk().equals("{A1")) {
				salaryView.setMoneyBrutto(invoices.getKwota().toString());
			}
			salaryView.setDate(currentDate);
			
			results.put(currentDate, salaryView);
		}

		return results;
	}

}
