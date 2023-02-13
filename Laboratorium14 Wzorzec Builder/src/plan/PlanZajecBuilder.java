package plan;

import dzien.Dzien;

public class PlanZajecBuilder {
	private Dzien[] tydzien;
	private int numerTygodnia;
	
	public PlanZajecBuilder()
	{
		tydzien=new Dzien[7];
	}
	
	public PlanZajecBuilder nDzien(int n, Dzien dzien)
	{
		tydzien[n-1]=dzien;
		return this;
	}
	
	public PlanZajecBuilder numerTygodnia(int numerTygodnia)
	{
		this.numerTygodnia=numerTygodnia;
		return this;
	}
	public PlanZajec build()
	{
		return new PlanZajec(tydzien,numerTygodnia);
	}
}
