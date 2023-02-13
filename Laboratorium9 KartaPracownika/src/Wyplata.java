
public class Wyplata {
	
	private static int numerWyplaty=0;
	private double pensja;
	private KartaPracownika karta;
	public Wyplata()
	{
		pensja=0;
		karta=null;
		numerWyplaty++;;
	}
	public Wyplata(double pensja, KartaPracownika karta)
	{
		this.karta=karta;
		this.pensja=pensja;
		numerWyplaty++;
	}
	public String toString()
	{
		return karta.toString()+", "+"pensja (bez premii): "+pensja+", pensja z premia: "+pensjaZPremia();
	}
	public double pensjaZPremia()
	{
		return Math.round(pensja*(karta.premia()+1)*100)/100.0;
	}
	public static int getNumerWyplaty() {
		return numerWyplaty;
	}
	public static void setNumerWyplaty(int numerWyplaty) {
		Wyplata.numerWyplaty = numerWyplaty;
	}
	public double getPensja() {
		return pensja;
	}
	public void setPensja(double pensja) {
		this.pensja = pensja;
	}
	public KartaPracownika getKarta() {
		return karta;
	}
	public void setKarta(KartaPracownika karta) {
		this.karta = karta;
	}
	

}
