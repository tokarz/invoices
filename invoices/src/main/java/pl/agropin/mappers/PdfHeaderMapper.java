package pl.agropin.mappers;

import java.util.List;

import entities.Invoices;
import pl.agropin.views.PdfHeader;

public class PdfHeaderMapper {

	public PdfHeader mapPdfHeaders(List<Invoices> currentInvoices) {
		PdfHeader header = new PdfHeader();
		if(currentInvoices != null && currentInvoices.size() > 0)
		{
			Invoices firstInvoice = currentInvoices.get(0);
			
			String imie = firstInvoice.getImieprac();
			String nazwisko = firstInvoice.getNazwiskoprac();
			String adres = firstInvoice.getOddzialnfz();
			String dzialSekcjaPracownika = "___dzial sekcja pracownika___";
			String nazwaFirmy = "___nazwa firmy____";
			String nip = "__NIP__";
			String okresRozliczeniowy = firstInvoice.getRokobr() + "." + firstInvoice.getMcobr();
			String pesel = "__pesel__";
			String stawkaPlaca = "???? jak to odczytac?";
			
			header.setAdres(adres);
			header.setDzialSekcjaPracownika(dzialSekcjaPracownika);
			header.setImie(imie);
			header.setNazwisko(nazwisko);
			header.setNazwaFirmy(nazwaFirmy);
			header.setNip(nip);
			header.setOkresRozliczeniowy(okresRozliczeniowy);
			header.setPesel(pesel);
			header.setStawkaPlaca(stawkaPlaca);
			header.setDzialSekcjaPracownika(dzialSekcjaPracownika);
		}
		
		
		
		return header;
	}

}
