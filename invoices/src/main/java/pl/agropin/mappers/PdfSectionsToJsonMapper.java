package pl.agropin.mappers;

import pl.agropin.views.PdfHeader;
import pl.agropin.views.PdfSections;

public class PdfSectionsToJsonMapper {

	public String map(PdfSections pdfSections) {
		String template = "{" + "\"content\": [" + "{" + "\"style\": 'tableExample',"
				+ "\"table\": {" + "\"widths\": [ 500 ],"
				+ "\"body\": ["
				+"[" + "{ \"text\": ["
				+ "{ \"text\": 'TEST SP Z O O\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": 'NIP 7775554433\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": 'Okres rozliczneniowy :{{date}}\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": 'Pesel 80010101257\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '15R WIELKOPOLSKA RKCH W POZNANIU\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": 'Stawka/p³aca\\\\t\\\\t\\\\t 1 980, 00\\\\n\\\\n\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": 'R6 08 00004\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '{{name}}\\\\n', \"fontSize\": 10 }" +
		"]}" +
		"]]}},"
				+ "{ \"text\": [" + "{ \"text\": '001 P£.ZASADN.\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '176.0\\\\t', \"fontSize\": 10 }," + "			{ \"text\": '1 980,00\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '109 D.SZKOD10%\\\\t', \"fontSize\": 10 }," + "			{ \"text\": '66\\\\t', \"fontSize\": 10 },"
				+ "{ \"text\": '51,98\\\\n', \"fontSize\": 10 }," + "			{ \"text\": '128 NDG.1000KR\\\\t', \"fontSize\": 10 },"
				+ "{ \"text\": '12,0\\\\t', \"fontSize\": 10 }," + "			{ \"text\": '270\\\\n\\\\n', \"fontSize\": 10 }"
				+ "]},{\"table\": {\"widths\": [ 500 ],"
				+ "\"body\": [" +
		"[{ \"text\": ["
				+ "{ \"text\": 'BRUTTO.\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '2 301,98', \"style\": 'rowLeft' }"
				+ "]}]]}}," +
		"{ \"text\": [{ \"text\": '\\\\n500 Skl.emer.P\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '9,76\\\\t', \"fontSize\": 10 }," + "{ \"text\": '- 224,67\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '501 Skl.rent.P\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '1,50\\\\t', \"fontSize\": 10 }," + "{ \"text\": '- 34,53\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '502 Skl.chor.P\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '2,45\\\\t', \"fontSize\": 10 }," + "{ \"text\": '- 56,40\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '903 PKZP po¿.\\\\t', \"style\": 'row' }," + "			{ \"text\": '\\\\t', \"fontSize\": 10 },"
				+ "{ \"text\": '- 165,00\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '905 PKZP sk³.\\\\t', \"style\": 'row' }," + "{ \"text\": '\\\\t', \"fontSize\": 10 },"
				+ "{ \"text\": '- 10,00\\\\n', \"fontSize\": 10 }," + "{ \"text\": '915 Ubezp.\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '0,00\\\\t', \"fontSize\": 10 }," + "{ \"text\": '- 49,00\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '962 Pod.wyn.\\\\t', \"style\": 'row' }," + "{ \"text\": '18,00\\\\t', \"fontSize\": 10 },"
				+ "{ \"text\": '- 132,00\\\\n', \"fontSize\": 10 }," + "{ \"text\": '980 ROR\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '\\\\t', \"fontSize\": 10 }," + "{ \"text\": '- 1 451,61\\\\n\\\\n', \"fontSize\": 10 }" +
		"]},{\"table\": {\"widths\": [ 500 ],"
				+ "\"body\": [" +
		"[{ \"text\": ["
				+ "{ \"text\": 'POTR¥CENIA.\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '- 2 301,98', \"style\": 'rowLeft' }"
				+ "]}]]}},{ \"text\": [{ \"text\": '\\\\n510 Skl.emer.Z\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '9,76\\\\t', \"fontSize\": 10 },{ \"text\": '224,67\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '511 Skl.rent.Z\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '4,50\\\\t', \"fontSize\": 10 },{ \"text\": '103,59\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '513 Skl.wypd.Z\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '3,54\\\\t', \"fontSize\": 10 },{ \"text\": '81,49\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '560 Zmniej.pod\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '7,75\\\\t', \"fontSize\": 10 },{ \"text\": '153,94\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '800 ULGA POD.\\\\t', \"style\": 'row' },{ \"text\": '\\\\t', \"fontSize\": 10 },"
				+ "{ \"text\": '46,33\\\\n', \"fontSize\": 10 },{ \"text\": '810 KOSZTY UZ.\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '\\\\t', \"fontSize\": 10 },{ \"text\": '- 139,06\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '810 Ulga zast.\\\\t', \"style\": 'row' },{ \"text\": '\\\\t', \"fontSize\": 10 },"
				+ "{ \"text\": '46,33\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '811 Koszt zast.\\\\t', \"style\": 'row' },{ \"text\": '\\\\t', \"fontSize\": 10 },"
				+ "{ \"text\": '- 139,06\\\\n\\\\n', \"fontSize\": 10 },"
				+ "{ \"text\": '960 Pod.nal\\\\t', \"style\": 'row' },{ \"text\": '18,00\\\\t', \"fontSize\": 10 },"
				+ "{ \"text\": '- 285,94\\\\n\\\\n', \"fontSize\": 10 }" +
		"]},{\"table\": {\"widths\": [ 300 ],"
				+ "\"body\": [" +
		"[{ \"text\": ["
				+ "{ \"text\": 'Do wyp³aty.\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '0,00', \"style\": 'rowLeft' }"
				+ "]}]]}},{\"text\":'\\\\n'},{\"table\": {"
				+ "\"widths\": [ 300 ],\"body\": [" +
		"[{ \"text\": ["
				+ "{ \"text\": 'Stan wk³adów PKZP\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '540,00\\\\n', \"style\": 'rowLeft' },"
				+ "{ \"text\": 'Zad³u¿enie PKZP1\\\\t', \"style\": 'row' },"
				+ "{ \"text\": '   350,00', \"style\": 'rowLeft' }"
				+ "]}]]}}" +
		"]," + "styles: {header: {\"fontSize\": 16,\"bold\": true,"
				+ "\"margin\": [0, 0, 0, 10]},\"subheader\": {\"fontSize\": 14,"
				+ "\"bold\": true,\"margin\": [0, 10, 0, 5]},\"tableExample\": {"
				+ "\"margin\": [0, 5, 0, 15]},\"tableHeader\": {\"bold\": true,"
				+ "\"fontSize\": 11,\"color\": 'black'},\"row\": {"
				+ "\"margin\": [0,0,0,10],\"fontSize\": 10" +
		"},\"rowLeft\": {\"fontSize\": 10,\"alignment\": 'right'" +
		"}}}";

		PdfHeader pdfHeader = pdfSections.getPdfHeader();
		// pdfHeader.getAdres();
		// pdfHeader.getDzialSekcjaPracownika();
		String fName = pdfHeader.getImie();
		String lName = pdfHeader.getNazwisko();
		// pdfHeader.getNip();
		String date = pdfHeader.getOkresRozliczeniowy();
		// pdfHeader.getPesel();
		// pdfHeader.getStawkaPlaca();
		//
		// String jsonBig = "{\"content\": [{";
		// jsonBig+= "\"table\": {";//table opening
		// jsonBig+= "\"body\": [";//body opening
		// jsonBig+="[";//body content start
		//
		// jsonBig += "\"" + pdfHeader.getNazwaFirmy() + "\",";
		// jsonBig += "\"" + pdfHeader.getNazwaFirmy() + "\",";
		// jsonBig += "\"" + "Okres rozliczeniowy \\\\t:" + pdfHeader.getNip() +
		// "\",";
		// jsonBig += "\"" + pdfHeader.getPesel() + "\",";
		// jsonBig += "\"" + pdfHeader.getAdres() + "\",";
		// jsonBig += "\"" + "Stawka/placa\\\\t\\\\t " + pdfHeader.getStawkaPlaca() +
		// "\",";
		// jsonBig += "\"" + pdfHeader.getDzialSekcjaPracownika() + "\",";
		// jsonBig += "\"" + pdfHeader.getNazwisko() + " " + pdfHeader.getImie()
		// + "\",";;
		// jsonBig += "\"" + pdfHeader.getNazwaFirmy() + "\",";;
		// jsonBig += "\"" + pdfHeader.getNazwaFirmy() + "\",";
		//
		// jsonBig+="]";// body content end
		// jsonBig+="]";//body closing
		// jsonBig+= "}";//table closing
		// jsonBig += "}]}";

		String result = template.replace("{{date}}", date);
		result = result.replace("{{name}}", lName + " " + fName);

		return result;
	}

}
