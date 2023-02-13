package dzien;
import java.util.ArrayList;
import zajecia.Zajecia;

public class DzienBuilder {
	
	private Zajecia[] zajecia;
	private ArrayList<String> uroczystosci;
	
	public DzienBuilder()
	{
		zajecia=new Zajecia[9];
		uroczystosci = new ArrayList<>();
	}
	
	public DzienBuilder nLekcja(int n,Zajecia lekcjaN)
	{
		zajecia[n-1]=lekcjaN;
		return this;
	}
	
	public Dzien build()
	{
		return new Dzien(zajecia,uroczystosci);
	}
	
	public DzienBuilder addUroczystosci(String uroczystosc)
	{
		uroczystosci.add(uroczystosc);
		return this;
	}
	
}
