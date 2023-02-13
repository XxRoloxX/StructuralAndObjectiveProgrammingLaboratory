package zajecia;

import osoba.Osoba;
import zajecia.Zajecia;

public class ZajeciaBuilder {
	
	private String nazwa;
	private Osoba prowadzacy;
	private String tryb;
	private String rodzajZaliczenia;
	
	public ZajeciaBuilder nazwa(String nazwa) {
		this.nazwa = nazwa;
		return this;
	}
	public ZajeciaBuilder prowadzacy(Osoba prowadzacy) {
		this.prowadzacy = prowadzacy;
		return this;
	}
	public ZajeciaBuilder tryb(String tryb) {
		this.tryb = tryb;
		return this;
	}
	public ZajeciaBuilder rodzajZaliczenia(String rodzajZaliczenia) {
		this.rodzajZaliczenia = rodzajZaliczenia;
		return this;
	}
	public Zajecia build()
	{
		return new Zajecia(nazwa,prowadzacy,tryb,rodzajZaliczenia);
	}
	

}
