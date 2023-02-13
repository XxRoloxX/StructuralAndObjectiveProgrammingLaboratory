import java.util.Random;

public class Przychodnia {
	
	private Osoba [] osoby = new Osoba[20];
	private int n;
	
	public Przychodnia(int n)
	{	
		this.n=n;
		wypelnij();
	}
	public Osoba wybierzLosowo()
	{
		Osoba wynik=null;
		Random g = new Random();
		int z = g.nextInt(4);
		
		switch(z)
		{
		case 0:
			wynik=new Pacjent();
			break;
		case 1:
			wynik=new Pacjent("Kowalski","233121323",g.nextInt(10));
			break;
		case 2:
			wynik = new Lekarz();
			break;
		case 3:
			wynik = new Lekarz("Nowak", "190291821","internista",g.nextInt(100));
			break;
		default:
			break;
		}
		
		return wynik;
		
	}
	public void wypelnij()
	{
		for(int i=0;i<n;i++)
		{
			osoby[i]=wybierzLosowo();
		}
	}
	public void wstaw(Osoba ob)
	{
		if(n<osoby.length)
		{
			osoby[n]=ob;
		}
		else
		{
			Osoba[] tmp = new Osoba[osoby.length+1];
			
			for(int i=0;i<n;i++)
			{
				tmp[i]=osoby[i];
			}
			
			tmp[n]=ob;
			osoby=tmp;
		}
		n++;
	}
	public void wyswietl()
	{
		for(int i=0;i<n;i++)
		{
			System.out.println(osoby[i]);
		}
	}
	public void wyswietlLekarzy()
	{
		for(int i=0;i<n;i++)
		{
			if(osoby[i] instanceof Lekarz)
			{
				System.out.println(osoby[i]+", "+((Lekarz)osoby[i]).ileWizyt());
				((Lekarz)osoby[i]).wyswietlLiczbePacjentow();
				System.out.println();
			}
		}
	}
	public void wyswietlPacjentow()
	{
		for(int i=0;i<n;i++)
		{
			if(osoby[i] instanceof Pacjent)
			{
				System.out.println(osoby[i]+": ");
				((Pacjent)osoby[i]).wyswietlWizyty();
				System.out.println();
				
			}
			
		}
	}
	public int ileInternistow()
	{
		int wynik=0;
		for(int i=0;i<n;i++)
		{
			if(osoby[i] instanceof Lekarz && ((Lekarz)osoby[i]).jestInternista())
			{
				wynik++;
			}
		}
		return wynik;
	}
	public String najwiecejZarobil()
	{
		double maxZarobki=-1;
		String maxSpecjalizacja=null;
		//boolean pierwszy=true;
		
		for(int i=0;i<n;i++)
		{
			if(osoby[i] instanceof Lekarz)
			{
				/*if(pierwszy)
				{
					maxZarobki=osoby[i].Oblicz();
					maxSpecjalizacja=((Lekarz)osoby[i]).getS();
					pierwszy=false;
				} */
				if(osoby[i].Oblicz()>maxZarobki)
				{
					maxZarobki=osoby[i].Oblicz();
					maxSpecjalizacja=((Lekarz)osoby[i]).getS();
				}
			}
		}
		return maxSpecjalizacja;
	}
	
	public static void main(String[] args) {
		
		Przychodnia p = new Przychodnia(20);
		p.wyswietl();
		System.out.println();
		p.wyswietlLekarzy();
		System.out.println();
		p.wyswietlPacjentow();
		System.out.println();
		System.out.println(p.najwiecejZarobil());
		System.out.println(p.ileInternistow());
		
		
	}

}
