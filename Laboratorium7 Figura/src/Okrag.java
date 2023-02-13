
public class Okrag extends Figura{
	
	private int r;
	private int x;
	private int y;
	
	public Okrag()
	{
		super("Bazowy");
		r=1;
		x=0;
		y=0;
	}
	
	public Okrag(String nazwa, int r, int x, int y)
	{
		super(nazwa);
		this.r=r;
		this.x=x;
		this.y=y;
		
	}
	
	public double Obwod()
	{
		return 2*Math.PI*r;
	}
	public double Pole()
	{
		return Math.PI*r*r;
	}
	
	public String toString()
	{
		return "Okrag: "+getNazwa()+"[r="+r+", x="+x+", y="+y+"]";
	}
	public double odleglosc(int x, int y)
	{
		return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
	}
	public boolean nalezy(int x, int y)
	{
		if(odleglosc(x,y)<r) return true;
		return false;
	}
	
	

}
