package dzien;
import zajecia.Zajecia;

import java.util.ArrayList;
import java.util.Date;

public class Dzien {
	
	private Zajecia[] zajecia;
	private ArrayList<String> uroczystosci;
	
	
	public Dzien(Zajecia[] zajecia,ArrayList<String> uroczystosci)
	{
		this.zajecia=zajecia;
		this.uroczystosci=uroczystosci;
		
	}
	
	public Zajecia getNZajecia(int i)
	{
		return zajecia[i-1];
	}
	public ArrayList<String> getUroczystosci()
	{
		return uroczystosci;
	}
	public Zajecia[] getZajecia()
	{
		return zajecia;
	}
}
