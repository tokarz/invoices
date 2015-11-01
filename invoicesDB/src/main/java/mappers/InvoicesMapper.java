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
					try {
						Invoices invoice = mapSingleRow(row);
						results.add(invoice);
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			}
		}
		return results;
	}

	private Invoices mapSingleRow(List<DbfColumnValue> row) {
		Invoices invoice = new Invoices();
		for (DbfColumnValue dbfColumnValue : row) {
			switch (dbfColumnValue.field.getName()) {
			case "ROKOBR":
				System.out.println("parsing rokobr");
				invoice.setRokobr((String) dbfColumnValue.value);
				break;
			case "MCOBR":
				System.out.println("parsing mcobr");
				invoice.setMcobr(dbfColumnValue.value.toString());
				break;
			case "ROKPOD":
				System.out.println("parsing 3");
				invoice.setRokpod(dbfColumnValue.value.toString());
				break;
			case "MCPOD":
				System.out.println("parsing 4");
				invoice.setMcpod(dbfColumnValue.value.toString());
				break;
			case "TERMIN":
				System.out.println("parsing 5");
				invoice.setTermin((String) dbfColumnValue.value);
				break;

			case "NRPRAC":
				System.out.println("parsing 6");
				invoice.setNrprac((String) dbfColumnValue.value);
				break;
			case "NAZWISKOPR":
				System.out.println("parsing 7");
				invoice.setNazwiskoprac((String) dbfColumnValue.value);
				break;
			case "IMIEPRAC":
				System.out.println("parsing 8");
				invoice.setImieprac((String) dbfColumnValue.value);
				break;
			case "ANGAZPLACA":
				System.out.println("9");
				invoice.setAngazplaca((Double) dbfColumnValue.value);
				break;
			case "ANGAZCRYPT":
				System.out.println("10");
				invoice.setAngazcrypt((String) dbfColumnValue.value);
				break;
			case "LENANGAZ":
				System.out.println("11");
				invoice.setLenangaz((Long) dbfColumnValue.value);
				break;
			case "SKLADNIK":
				System.out.println("12");
				invoice.setSkladnik((String) dbfColumnValue.value);
				break;
			case "KL3_SK":
				System.out.println("13");
				invoice.setKl3_sk((String) dbfColumnValue.value);
				break;
			case "SYMB_SK":
				System.out.println("14");
				invoice.setSymb_sk((String) dbfColumnValue.value);
				break;
			case "NAZP_SK":
				System.out.println("15");
				invoice.setNazp_sk((String) dbfColumnValue.value);
				break;
			case "NAZS_SK":
				System.out.println("16");
				invoice.setNazs_sk((String) dbfColumnValue.value);
				break;
			case "WSK_ODC":
				System.out.println("17");
				invoice.setWsk_odc((String) dbfColumnValue.value);
				break;
			case "ILO_GODZ":
				System.out.println("18");
				invoice.setIlo_godz(Double.parseDouble(dbfColumnValue.value.toString()));
				break;
			case "PROCENT":
				System.out.println("19");
				invoice.setProcent((Double) dbfColumnValue.value);
				break;
			case "KWOTA":
				System.out.println("20");
				invoice.setKwota((Double) dbfColumnValue.value);
				break;
			case "KWOTACRYPT":
				System.out.println("21");
				invoice.setKwotacrypt((String) dbfColumnValue.value);
				break;
			case "LENKWOTA":
				System.out.println("22");
				invoice.setLenkwota((Long) dbfColumnValue.value);
				break;
			case "LDOD":
				System.out.println("23");
				invoice.setLdod((String) dbfColumnValue.value);
				break;
			case "NR_LISTY":
				System.out.println("24");
				invoice.setNr_listy((String) dbfColumnValue.value);
				break;
			case "ZAKLAD":
				System.out.println("25");
				invoice.setZaklad((String) dbfColumnValue.value);
				break;
			case "WYDZIAL":
				System.out.println("26");
				invoice.setWydzial((String) dbfColumnValue.value);
				break;
			case "PODWYDZIAL":
				System.out.println("27");
				invoice.setPodwydzial((String) dbfColumnValue.value);
				break;
			case "KONTO5":
				System.out.println("28");
				invoice.setKonto5((String) dbfColumnValue.value);
				break;
			case "ZAKLADPRAC":
				System.out.println("29");
				invoice.setZakladprac((String) dbfColumnValue.value);
				break;
			case "WYDZIALPRA":
				System.out.println("30");
				invoice.setWydzialprac((String) dbfColumnValue.value);
				break;
			case "PODWYDZIAL2":
				System.out.println("31");
				invoice.setPodwydzialprac((String) dbfColumnValue.value);
				break;
			case "KONTO5PRAC":
				System.out.println("32");
				invoice.setKonto5prac((String) dbfColumnValue.value);
				break;
			case "ODDZIALNFZ":
				System.out.println("33");
				invoice.setOddzialnfz((String) dbfColumnValue.value);
				break;
			case "PRZELEWROR":
				System.out.println("34");
				invoice.setPrzelewror((Double) dbfColumnValue.value);
				break;
			case "RORCRYPT":
				System.out.println("35");
				invoice.setRorcrypt((String) dbfColumnValue.value);
				break;
			case "LENROR":
				System.out.println("36");
				invoice.setLenror((Long) dbfColumnValue.value);
				break;
			case "PRZELEWRO2":
				System.out.println("37");
				invoice.setPrzelewror((Double) dbfColumnValue.value);
				break;
			case "ROR2CRYPT":
				System.out.println("38");
				invoice.setRorcrypt((String) dbfColumnValue.value);
				break;
			case "LENROR2":
				System.out.println("39");
				invoice.setLenror2((Long) dbfColumnValue.value);
				break;
			case "WYPLATAKAS":
				System.out.println("40");
				invoice.setWyplatakasa((Double) dbfColumnValue.value);
				break;
			case "KASACRYPT":
				System.out.println("41");
				invoice.setKasacrypt((String) dbfColumnValue.value);
				break;
			case "LENKASA":
				System.out.println("42");
				invoice.setLenkasa((Long) dbfColumnValue.value);
				break;
			case "WYSLANY":
				System.out.println("43");
				invoice.setWyslany((String) dbfColumnValue.value);
				break;
			case "SUMAKTRL":
				System.out.println("44");
				invoice.setSumaktrl((Double) dbfColumnValue.value);
				break;
			}

		}
		return invoice;
	}

}
