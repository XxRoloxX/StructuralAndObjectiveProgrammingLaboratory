package konwerter;

public abstract class Konwerter {
	private static final double PRZELICZNIK = 4.29;
	
	public static double euroNaZlote(double euro)
	{
		return euro*PRZELICZNIK;
	}
	
	public static double zloteNaEuro(double zlote)
	{
		return zlote/PRZELICZNIK;
	}
	
}
