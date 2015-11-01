package pl.agropin.mappers;

import pl.agropin.views.PdfHeader;
import pl.agropin.views.PdfSections;



public class PdfSectionsToJsonMapper {

	public String map(PdfSections pdfSections) {
		PdfHeader pdfHeader = pdfSections.getPdfHeader();
		pdfHeader.getAdres();
		pdfHeader.getDzialSekcjaPracownika();
		pdfHeader.getImie();
		pdfHeader.getNazwisko();
		pdfHeader.getNip();
		pdfHeader.getOkresRozliczeniowy();
		pdfHeader.getPesel();
		pdfHeader.getStawkaPlaca();
		
		String jsonBig = "{\"content\": [{";
		jsonBig+= "\"table\": {";//table opening
		jsonBig+= "\"body\": [";//body opening
		jsonBig+="[";//body content start
		
		jsonBig += "\"" + pdfHeader.getNazwaFirmy() + "\",";
		jsonBig += "\"" + pdfHeader.getNazwaFirmy() + "\",";
		jsonBig += "\"" + "Okres rozliczeniowy \t:" + pdfHeader.getNip() + "\",";
		jsonBig += "\"" + pdfHeader.getPesel() + "\",";
		jsonBig += "\"" + pdfHeader.getAdres() + "\",";
		jsonBig += "\"" + "Stawka/placa\t\t " + pdfHeader.getStawkaPlaca() + "\",";
		jsonBig += "\"" + pdfHeader.getDzialSekcjaPracownika() + "\",";
		jsonBig += "\"" + pdfHeader.getNazwisko() + " " + pdfHeader.getImie() + "\",";;
		jsonBig += "\"" + pdfHeader.getNazwaFirmy() + "\",";;
		jsonBig += "\"" + pdfHeader.getNazwaFirmy() + "\",";
		
		jsonBig+="]";// body content end
		jsonBig+="]";//body closing
		jsonBig+= "}";//table closing
		jsonBig += "}]}";
		
		return jsonBig;
	}

}
