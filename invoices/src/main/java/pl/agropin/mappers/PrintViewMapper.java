package pl.agropin.mappers;

import java.util.List;

import entities.Invoices;
import pl.agropin.views.PdfFooter;
import pl.agropin.views.PdfHeader;
import pl.agropin.views.PdfSection;
import pl.agropin.views.PdfSections;

public class PrintViewMapper {

	private PdfHeaderMapper pdfHeaderMapper;
	private PdfSectionsMapper pdfSectionsMapper;
	private PdfFooterMapper pdfFooterMapper;

	public PrintViewMapper(PdfHeaderMapper pdfHeaderMapper, PdfSectionsMapper pdfSectionsMapper,
			PdfFooterMapper pdfFooterMapper) {
		this.pdfHeaderMapper = pdfHeaderMapper;
		this.pdfSectionsMapper = pdfSectionsMapper;
		this.pdfFooterMapper = pdfFooterMapper;
	}

	public PrintViewMapper() {
		this.pdfHeaderMapper = new PdfHeaderMapper();
		this.pdfSectionsMapper = new PdfSectionsMapper();
		this.pdfFooterMapper = new PdfFooterMapper();
	}

	public PdfSections mapInvoicesToPrintViews(List<Invoices> currentInvoices) {
		PdfHeader pdfHeader = pdfHeaderMapper.mapPdfHeaders(currentInvoices);
		List<PdfSection> pdfSections = pdfSectionsMapper.mapPdfHeaders(currentInvoices);
		PdfFooter pdfFooter = pdfFooterMapper.mapPdfFooter(currentInvoices);
		
		PdfSections results = new PdfSections();
		results.setPdfSections(pdfSections);
		results.setPdfHeader(pdfHeader);
		results.setPdfFooter(pdfFooter);
		
		return results;
	}

}
