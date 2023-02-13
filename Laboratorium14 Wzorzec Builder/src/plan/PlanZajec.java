package plan;

import dzien.Dzien;
import zajecia.Zajecia;

public class PlanZajec {
	private Dzien[] tydzien;
	private int numerTygodnia;
	
	public PlanZajec(Dzien[] tydzien, int numerTygodnia)
	{
		this.tydzien=tydzien;
		this.numerTygodnia=numerTygodnia;
	}
	public Dzien getNDzien(int n)
	{
		return tydzien[n-1];
	}
	public int getNumerTygodnia()
	{
		return numerTygodnia;
	}
	
	public void wyswietlPlan()
	{
		Zajecia[] zajecia;
		for(int i=0;i<tydzien.length;i++)
		{
			System.out.println("Dzien: "+(i+1));
			if(tydzien[i]!=null)
			{
				zajecia=tydzien[i].getZajecia();
				for(int j=0;j<zajecia.length;j++)
				{
					if(zajecia[j]!=null)
					System.out.printf("Godzina %2d: %40s%n",(j+1),zajecia[j]);
				}
			}
			else
			{
				System.out.println("Brak zajęć");
			}
			
		}
	}
}
