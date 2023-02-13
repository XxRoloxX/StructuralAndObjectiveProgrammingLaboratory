package zajecia;
import osoba.Osoba;

public class Zajecia {
	
	private String nazwa;
	private Osoba prowadzacy;
	private String tryb;
	private String rodzajZaliczenia;
	
	public Zajecia(String nazwa, Osoba prowadzacy,String tryb, String rodzajZaliczenia)
	{
		this.nazwa=nazwa;
		this.prowadzacy=prowadzacy;
		this.tryb=tryb;
		this.rodzajZaliczenia=rodzajZaliczenia;
	}
	public String getNazwa() {
		return nazwa;
	}
	public Osoba getProwadzacy() {
		return prowadzacy;
	}
		public String getTryb() {
		return tryb;
	}
	public String getRodzajZaliczenia() {
		return rodzajZaliczenia;
	}
	
	public String toString()
	{
		return String.format("%-10s %-20s %-15s %-10s",nazwa,prowadzacy,tryb,rodzajZaliczenia);
	}
	
	
}
