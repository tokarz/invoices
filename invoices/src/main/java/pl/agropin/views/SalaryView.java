package pl.agropin.views;

import java.util.ArrayList;
import java.util.List;

public class SalaryView {
	private String summaryTitle;
	private List<Part> parts = new ArrayList<Part>();
	public String getSummaryTitle() {
		return summaryTitle;
	}
	public void setSummaryTitle(String summaryTitle) {
		this.summaryTitle = summaryTitle;
	}
	public List<Part> getParts() {
		return parts;
	}
	public void setParts(List<Part> parts) {
		this.parts = parts;
	}
	
	
	
}
