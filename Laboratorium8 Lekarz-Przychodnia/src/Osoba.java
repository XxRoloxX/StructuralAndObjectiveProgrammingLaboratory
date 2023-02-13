
public abstract class Osoba {
	private String nazwisko;
	private String pesel;
	public Osoba()
	{
		nazwisko="";
		pesel="";
	}
	
	public Osoba(String nazwisko, String pesel)
	{
		this.nazwisko=nazwisko;
		this.pesel=pesel;
	}
	public String toString()
	{
		return nazwisko + " " + pesel;
	}
	public abstract double Oblicz();

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
}
