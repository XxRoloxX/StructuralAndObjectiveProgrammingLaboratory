package osoba;

public class OsobaBuilder {
	private String imie;
	private String nazwisko;
	private String indeks;
	private String identyfikator;
	
	public OsobaBuilder imie(String imie)
	{
		this.imie=imie;
		return this;
	}
	public OsobaBuilder nazwisko(String nazwisko)
	{
		this.nazwisko=nazwisko;
		return this;
	}
	public OsobaBuilder indeks(String indeks)
	{
		this.indeks=indeks;
		return this;
	}
	public OsobaBuilder identyfikator(String identyfikator)
	{
		this.identyfikator=identyfikator;
		return this;
	}
	public Osoba build()
	{
		return new Osoba(imie,nazwisko,indeks,identyfikator);
	}
}
