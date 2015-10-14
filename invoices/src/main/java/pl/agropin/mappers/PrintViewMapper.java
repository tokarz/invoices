package pl.agropin.mappers;

import java.util.ArrayList;
import java.util.List;

import entities.Invoices;
import pl.agropin.views.PrintView;

public class PrintViewMapper {

	public List<PrintView> mapInvoicesToPrintViews(List<Invoices> currentInvoices) {
		List<PrintView> results = new ArrayList<PrintView>();
		PrintView printView = new PrintView();
		for (Invoices invoices : currentInvoices) {
			if (invoices.getSymb_sk().equals("001")) {
				printView.setKodPlacaZasadnicza("001");
				printView.setPlacaZasadnicza(invoices.getIlo_godz().toString());
			}
			if (invoices.getSymb_sk().equals("109")) {
				printView.setKodDSzkod10Procens("109");
				printView.setKodDSzkod10Procens(invoices.getIlo_godz().toString());
			}

			if (invoices.getSymb_sk().equals("128")) {
				printView.setKodNdg1000kr("128");
				printView.setNdg1000kr(invoices.getIlo_godz().toString());
			}
		}

		results.add(printView);
		return results;
	}

}
