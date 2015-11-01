package pl.agropin.views;

import java.util.List;

public class PdfSections {
	private PdfHeader pdfHeader;
	private List<PdfSection> pdfSections;
	private PdfFooter pdfFooter;

	public PdfHeader getPdfHeader() {
		return pdfHeader;
	}

	public void setPdfHeader(PdfHeader pdfHeader) {
		this.pdfHeader = pdfHeader;
	}

	public List<PdfSection> getPdfSections() {
		return pdfSections;
	}

	public void setPdfSections(List<PdfSection> pdfSections) {
		this.pdfSections = pdfSections;
	}

	public PdfFooter getPdfFooter() {
		return pdfFooter;
	}

	public void setPdfFooter(PdfFooter pdfFooter) {
		this.pdfFooter = pdfFooter;
	}
}
