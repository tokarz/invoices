package pl.agropin.views;

import java.util.List;

public class PdfSection {
	private List<String> tytuly;
	private List<String> srodkowaKolumna;
	private List<String> prawaKolumna;
	private String nazwaSekcji;
	public List<String> getTytuly() {
		return tytuly;
	}
	public void setTytuly(List<String> tytuly) {
		this.tytuly = tytuly;
	}
	public List<String> getSrodkowaKolumna() {
		return srodkowaKolumna;
	}
	public void setSrodkowaKolumna(List<String> srodkowaKolumna) {
		this.srodkowaKolumna = srodkowaKolumna;
	}
	public List<String> getPrawaKolumna() {
		return prawaKolumna;
	}
	public void setPrawaKolumna(List<String> prawaKolumna) {
		this.prawaKolumna = prawaKolumna;
	}
	public String getNazwaSekcji() {
		return nazwaSekcji;
	}
	public void setNazwaSekcji(String nazwaSekcji) {
		this.nazwaSekcji = nazwaSekcji;
	}
}
