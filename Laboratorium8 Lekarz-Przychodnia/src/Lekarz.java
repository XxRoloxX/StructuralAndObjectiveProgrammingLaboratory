import java.util.Random;

public class Lekarz extends Osoba {
	private String s;
	private int stawka;
	private int [] t=null;
	
	public Lekarz()
	{
		super();
		s="brak";
		stawka=0;
		t=null;
		
	}
	
	public Lekarz(String nazwisko, String pesel, String spec, int stawka)
	{
		super(nazwisko,pesel);
		s=spec;
		this.stawka=stawka;
		t=new int[5];
		Random g = new Random();
		
		for(int i=0;i<t.length;i++)
		{
			t[i]=g.nextInt(11)+20;
		}
	}
	
	public double Oblicz()
	{
		return ileWizyt()*stawka;
	}
	public int ileWizyt()
	{
		int wynik=0;
		if(t!=null)
		{
			for(int i=0;i<t.length;i++)
			{
				wynik+=t[i];
			}
		}
		
		return wynik;
	}
	
	public String toString()
	{
		return "Lekarz: "+super.toString()+" [specjalizacja="+s+",stawka="+stawka+"]";
	}
	
	public void wyswietlLiczbePacjentow()
	{
		String [] dni= {"Poniedzialek","Wtorek","Sroda","Czwartek","Piatek"};
		if(t!=null)
		{
			for(int i=0;i<t.length;i++)
			{
				System.out.println(dni[i]+": "+t[i]);
			}
		}
		else
		{
			System.out.println("Brak pacjentow");
		}
	}
	
	public boolean jestInternista()
	{
		if(s.equals("internista"))
		{
			return true;
		}
		
		return false;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public int getStawka() {
		return stawka;
	}

	public void setStawka(int stawka) {
		this.stawka = stawka;
	}

	public int[] getT() {
		return t;
	}

	public void setT(int[] t) {
		this.t = t;
	}
	
}
