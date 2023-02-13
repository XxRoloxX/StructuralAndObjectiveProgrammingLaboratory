import java.util.Random;

public class Pacjent extends Osoba {
	private int n;
	private Wizyta[] wtab;
	
	public Pacjent()
	{
		super();
		n=0;
		wtab=null;
	}
	
	public Pacjent(String nazwisko, String pesel, int n)
	{
		super(nazwisko, pesel);
		this.n=n;
		wtab=new Wizyta[n];
		wypelnijWizyty();
	}
	public void wypelnijWizyty()
	{
		if(wtab!=null)
		{
			Random g = new Random();
			for(int i=0;i<n;i++)
			{
				wtab[i]=new Wizyta(g.nextInt(30),g.nextInt(30),true,true);
			}
		}
		
	}
	public void dodajWizyte(Wizyta w)
	{
		if(n<wtab.length)
		{
			wtab[n]=w;
		}
		else
		{
			Wizyta[] tmp = new Wizyta[wtab.length+1];
			
			for(int i=0;i<n;i++)
			{
				tmp[i]=wtab[i];
			}
			
			tmp[n]=w;
			wtab=tmp;
		}
		n++;
	}
	public double Oblicz()
	{
		double suma=0;
		if(wtab!=null)
		{
			for(int i=0;i<wtab.length;i++)
			{
				suma+=wtab[i].getCenaWizyty();
			}
		}
		return suma;
	}
	public String toString()
	{
		return "Pacjent: "+ super.toString()+": [n="+n+"]";
	}
	public void wyswietlWizyty()
	{
		if(wtab!=null)
		{
			for(int i=0;i<n;i++)
			{
				System.out.println(wtab[i]);
			}
		}
		
	}
}
