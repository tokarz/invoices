package mappers;

import java.util.ArrayList;
import java.util.List;

import entities.DbfColumnValue;
import entities.DbfData;
import entities.Invoices;

public class InvoicesMapper {

	public List<Invoices> mapDbfData(DbfData allMessagesByName) {
		List<Invoices> results = new ArrayList<Invoices>();
		if(allMessagesByName != null) {
			List<List<DbfColumnValue>> values = allMessagesByName.getValues();
			if (values != null) {
				for (List<DbfColumnValue> list : values) {
					Invoices invoice = new Invoices();

					for (DbfColumnValue dbfColumnValue : list) {
						switch (dbfColumnValue.field.getName()) {
						case "ROKOBR":
							invoice.setRokobr((String) dbfColumnValue.value);
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
						}
					}
					results.add(invoice);
				}
			}
			
		}
		return results;
	}

}
