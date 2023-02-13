
public class Prostokat extends Figura {
	private int a;
	private int b;
	
	public Prostokat()
	{
		super("Bazowy");
		a=1;
		b=1;
		
	}
	
	public Prostokat(String nazwa, int a, int b)
	{
		super(nazwa);
		this.a=a;
		this.b=b;
	}
	
	public double Obwod()
	{
		return 2*a+2*b;
	}
	
	public double Pole()
	{
		return a*b;
	}
	
	public String toString()
	{
		return "Prostokat: "+getNazwa()+"[a="+a+",b="+b+"]";
	}
	
	public boolean jestKwadratem()
	{
		if (a==b) return true;
		
		return false;
	}
	
	

}
