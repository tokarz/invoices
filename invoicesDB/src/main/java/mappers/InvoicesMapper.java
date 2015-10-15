package mappers;

import java.util.ArrayList;
import java.util.List;

import entities.DbfColumnValue;
import entities.DbfData;
import entities.Invoices;

public class InvoicesMapper {

	public List<Invoices> mapDbfData(DbfData allMessagesByName) {
		List<Invoices> results = new ArrayList<Invoices>();
		if (allMessagesByName != null) {
			List<List<DbfColumnValue>> values = allMessagesByName.getValues();
			if (values != null) {
				for (List<DbfColumnValue> row : values) {
					Invoices invoice = new Invoices();
					for (DbfColumnValue dbfColumnValue : row) {
						switch (dbfColumnValue.field.getName()) {
						case "ROKOBR":
							invoice.setRokobr((String) dbfColumnValue.value);
							break;
						case "MCOBR":
							invoice.setMcobr(dbfColumnValue.value.toString());
							break;
						case "NAZWISKOPR":
							invoice.setNazwiskoprac((String) dbfColumnValue.value);
							break;
						case "IMIEPRAC":
							invoice.setImieprac((String) dbfColumnValue.value);
							break;
						case "ANGAZPLACA":
							invoice.setAngazplaca((Double) dbfColumnValue.value);
							break;
						case "ROKPOD":
							invoice.setRokpod(dbfColumnValue.value.toString());
							break;
						case "KWOTA":
							invoice.setKwota((Double) dbfColumnValue.value);
							break;
						case "ILO_GODZ":
							invoice.setIlo_godz(Double.parseDouble(dbfColumnValue.value.toString()));
							break;
						case "SYMB_SK":
							invoice.setSymb_sk((String) dbfColumnValue.value);
							break;
						}

					}
					results.add(invoice);
				}
			}
		}
		return results;
	}

}
