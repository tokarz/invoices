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
						case "ROKPOD":
							invoice.setRokpod(dbfColumnValue.value.toString());
							break;
						case "MCPOD":
							invoice.setMcpod(dbfColumnValue.value.toString());
							break;
						case "TERMIN":
							invoice.setTermin((String) dbfColumnValue.value);
							break;
						
						case "NRPRAC":
							invoice.setNrprac((String) dbfColumnValue.value);
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
						case "ANGAZCRYPT":
							invoice.setAngazcrypt((String) dbfColumnValue.value);
							break;
						case "LENANGAZ":
							invoice.setLenangaz((Double) dbfColumnValue.value);
							break;
						case "SKLADNIK":
							invoice.setSkladnik((String) dbfColumnValue.value);
							break;
						case "KL3_SK":
							invoice.setKl3_sk((String) dbfColumnValue.value);
							break;
						case "SYMB_SK":
							invoice.setSymb_sk((String) dbfColumnValue.value);
							break;
						case "NAZP_SK":
							invoice.setNazp_sk((String) dbfColumnValue.value);
							break;
						case "NAZS_SK":
							invoice.setNazs_sk((String) dbfColumnValue.value);
							break;
						case "WSK_ODC":
							invoice.setWsk_odc((String) dbfColumnValue.value);
							break;
						case "ILO_GODZ":
							invoice.setIlo_godz(Double.parseDouble(dbfColumnValue.value.toString()));
							break;
						case "PROCENT":
							invoice.setProcent((Double) dbfColumnValue.value);
							break;						
						case "KWOTA":
							invoice.setKwota((Double) dbfColumnValue.value);
							break;
						case "KWOTACRYPT":
							invoice.setKwotacrypt((String) dbfColumnValue.value);
							break;
						case "LENKWOTA":
							invoice.setLenkwota((Long) dbfColumnValue.value);
							break;
						case "LDOD":
							invoice.setLdod((String) dbfColumnValue.value);
							break;
						case "NR_LISTY":
							invoice.setNr_listy((String) dbfColumnValue.value);
							break;
						case "ZAKLAD":
							invoice.setZaklad((String) dbfColumnValue.value);
							break;
						case "WYDZIAL":
							invoice.setWydzial((String) dbfColumnValue.value);
							break;
						case "PODWYDZIAL":
							invoice.setPodwydzial((String) dbfColumnValue.value);
							break;
						case "KONTO5":
							invoice.setKonto5((String) dbfColumnValue.value);
							break;
						case "ZAKLADPRAC":
							invoice.setZakladprac((String) dbfColumnValue.value);
							break;
						case "WYDZIALPRA":
							invoice.setWydzialprac((String) dbfColumnValue.value);
							break;
						case "PODWYDZIAL2":
							invoice.setPodwydzialprac((String) dbfColumnValue.value);
							break;
						case "KONTO5PRAC":
							invoice.setKonto5prac((String) dbfColumnValue.value);
							break;
						case "ODDZIALNFZ":
							invoice.setOddzialnfz((String) dbfColumnValue.value);
							break;
						case "PRZELEWROR":
							invoice.setPrzelewror((Double) dbfColumnValue.value);
							break;
						case "RORCRYPT":
							invoice.setRorcrypt((String) dbfColumnValue.value);
							break;
						case "LENROR":
							invoice.setLenror((Long) dbfColumnValue.value);
							break;
						case "PRZELEWRO2":
							invoice.setPrzelewror((Double) dbfColumnValue.value);
							break;
						case "ROR2CRYPT":
							invoice.setRorcrypt((String) dbfColumnValue.value);
							break;
						case "LENROR2":
							invoice.setLenror2((Long) dbfColumnValue.value);
							break;
						case "WYPLATAKAS":
							invoice.setWyplatakasa((Double) dbfColumnValue.value);
							break;
						case "KASACRYPT":
							invoice.setKasacrypt((String) dbfColumnValue.value);
							break;
						case "LENKASA":
							invoice.setLenkasa((Long) dbfColumnValue.value);
							break;
						case "WYSLANY":
							invoice.setWyslany((String) dbfColumnValue.value);
							break;
						case "SUMAKTRL":
							invoice.setSumaktrl((Double) dbfColumnValue.value);
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
