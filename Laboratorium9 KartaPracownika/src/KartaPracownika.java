
public abstract class KartaPracownika {
	protected int numer;
	protected String nazwisko;
	public KartaPracownika()
	{
		numer=0;
		nazwisko=null;
	}
	public KartaPracownika(int numer, String nazwisko)
	{
		this.nazwisko=nazwisko;
		this.numer=numer;
	}
	public String toString()
	{
		return "Nazwisko: "+nazwisko+", numer: "+numer;
	}
	
	public abstract double premia();
}
