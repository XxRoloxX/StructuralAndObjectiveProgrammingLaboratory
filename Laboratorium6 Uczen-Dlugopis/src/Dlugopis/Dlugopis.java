package Dlugopis;
import Uczen.Uczen;

public class Dlugopis {
	private Wklad wklad;
	private boolean jestwPiorniku;
	
	public Dlugopis(int n)
	{
		jestwPiorniku=true;
		wklad = new Wklad(n);
	}
	public Dlugopis()
	{
		jestwPiorniku=true;
		wklad = new Wklad(1);
	}
	public int getColor()
	{
		return wklad.getColor();
	}
	public void setColor(int n)
	{
		wklad.setColor(n);
	}
	public void setJestwPiorniku(boolean n)
	{
		jestwPiorniku=n;
	}
	public boolean getJestwPiorniku()
	{
		return jestwPiorniku;
	}
	public void getStan()
	{
		System.out.printf("kolor=%d jestwPiorniku=%b%n",getColor(),jestwPiorniku);

	}
	public void wlozDoPiornika()
	{
		Uczen.wlozDlugopis(this);
	}
	public void wyjmijZPiornika()
	{
		Uczen.wyjmijDlugopis(this);
	}
	

}
