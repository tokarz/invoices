package pl.agropin.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Invoices;
import pl.agropin.views.TableRowView;

public class SalaryViewMapper {

	public Map<String, TableRowView> mapInvoicesToSalaryView(List<Invoices> currentInvoices) {
		Map<String, TableRowView> result = new HashMap<String, TableRowView>();
		for (Invoices invoice : currentInvoices) {
			String sk = invoice.getSymb_sk();
			String date = invoice.getRokobr() + "." + invoice.getMcobr();
			if (result.containsKey(date)) {
				TableRowView tableRowView = result.get(date);

				if (sk.equals("001")) {
					String hours = invoice.getIlo_godz().toString();
					tableRowView.setHours(hours);
				} else if (sk.contains("A1")) {
					String brutto = invoice.getKwota().toString();
					tableRowView.setBrutto(brutto);
					tableRowView.setNetto("Some netto!");
				}

			} else {

				TableRowView tableRowView = new TableRowView();
				tableRowView.setDate(date);

				if (sk.equals("001")) {
					String hours = invoice.getIlo_godz().toString();
					tableRowView.setHours(hours);
				} else if (sk.contains("A1")) {
					String brutto = invoice.getKwota().toString();
					tableRowView.setBrutto(brutto);
					tableRowView.setNetto("Some netto!");
				}
				result.put(date, tableRowView);
			}
		}
		return result;
	}

}
