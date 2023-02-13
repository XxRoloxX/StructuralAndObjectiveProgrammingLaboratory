package osoba;

public class Osoba {
	
	private String imie;
	private String nazwisko;
	private String indeks;
	private String identyfikator;
	
	public Osoba(String imie,String nazwisko,String indeks,String identyfikator)
	{
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.indeks=indeks;
		this.identyfikator=identyfikator;
	}
	
	public String getImie()
	{
		return imie;
	}
	public String getNazwisko()
	{
		return nazwisko;
	}
	
	public String toString()
	{
		return String.format("%-10s %-10s %-10s %-10s",imie,nazwisko,identyfikator,indeks);
	}

	public String getIndeks() {
		return indeks;
	}

	public String getIdentyfikator() {
		return identyfikator;
	}
}
