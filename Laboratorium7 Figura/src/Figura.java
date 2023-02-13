
public abstract class Figura {
	
	private String nazwa;
	
	public Figura()
	{
		nazwa="";
	}
	public Figura(String nazwa)
	{
		this.nazwa=nazwa;
	}
	
	public String toString()
	{
		return "Figura o nazwie: "+nazwa;
	}
	public String getNazwa()
	{
		return nazwa;
	}
	public void setNazwa(String nazwa)
	{
		this.nazwa=nazwa;
	}
	
	public abstract double Obwod();
	
	public abstract double Pole();
	
}
