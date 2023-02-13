import java.util.Random;

public class Rysunki {
	
	private int n;
	private Figura[] ftab;
	
	public Rysunki()
	{
		ftab=new Figura[20];
		n=10;
		inicjalizacjaTablicy();
	}
	
	public Rysunki(int n, int rozmiar)
	{
		ftab = new Figura[rozmiar];
		this.n=n;
		inicjalizacjaTablicy();
	}
	public int getN()
	{
		return n;
	}
	public void setN(int n)
	{
		this.n=n;
	}
	
	public Figura[] getFtab()
	{
		return ftab;
	}
	
	public void wyswietl()
	{
		for(int i=0;i<n;i++)
		{
			System.out.printf("%2d: %s%n",i,ftab[i]);
		}
	}
	public void dodajFigure(Figura ob)
	{
		if(ob!=null)
		{
		Figura[] tmp;
		if(n<ftab.length)
		{
			tmp = new Figura[ftab.length];
	
		
		}
		else
		{
			tmp = new Figura[ftab.length+1];
		}
		for(int i=0;i<n;i++)
		{
			tmp[i]=ftab[i];
		}
		
		tmp[n] = ob;
		ftab=tmp;
		n++;
		}
		
	}
	public void losowaInicjalizacjaElementu(int i)
	{
		
		ftab[i]=zwrocLosowaFigure();
	}
	public Figura zwrocLosowaFigure()
	{
		Random g = new Random();
		int max=30;
		int z=g.nextInt(4)+1;
		Figura wynik=null;
		
		switch(z) {
			case 1:
				wynik = new Prostokat();
				break;
			case 2:
				wynik = new Okrag();
				break;
			case 3:
				wynik = new Prostokat("Ładny",g.nextInt(max)+1,g.nextInt(max)+1);
				break;
			case 4:
				wynik = new Okrag("Dowolny",g.nextInt(max)+1,g.nextInt(max)+1,g.nextInt(max)+1);
				break;
			default:
				break;
				
			}
		
		return wynik;

	}
	public void inicjalizacjaTablicy()
	{
		for(int i=0;i<n;i++)
		{
			losowaInicjalizacjaElementu(i);
		}
	}
	
	public void inicjalizacjaTablicyV2()
	{
		for(int i=0;i<n;i++)
		{
			dodajFigure(zwrocLosowaFigure());
		}
	}
	
	public void maxPole()
	{
		double max=ftab[0].Pole();;
		Figura Fmax=ftab[0];
		double pole;
		int idx=0;
		
		for(int i=1;i<n;i++)
		{
			pole=ftab[i].Pole();
			
			if(pole>max)
			{
				max=pole;
				Fmax=ftab[i];
				idx=i;
			}
		}
		
		System.out.println("Pozycja: "+idx+", "+Fmax);
	}
	public void wyswietlProstokaty()
	{
		for(int i=0;i<n;i++)
		{
			if(ftab[i] instanceof Prostokat)
			{
				System.out.printf("%2d: %s%n",i,ftab[i]);
			}
		}
	}
	public void wyswietlOkregi()
	{
		for(int i=0;i<n;i++)
		{
			if(ftab[i] instanceof Okrag)
			{
				System.out.printf("%2d: %s%n",i,ftab[i]);
			}
		}
	}
	
	public int ileKwadratow()
	{
		int wynik=0;
		
		for(int i=0;i<n;i++)
		{
			if(ftab[i] instanceof Prostokat && ((Prostokat)ftab[i]).jestKwadratem())
			{
				wynik++;
			}
		}
		
		return wynik;
	}
	
	public int doIluOkregow(int x, int y)
	{
		int wynik=0;
		
		for(int i=0;i<n;i++)
		{
			if(ftab[i] instanceof Okrag && ((Okrag)ftab[i]).nalezy(x,y))
			{
				wynik++;
			}
		}
		
		return wynik;
	}
	
	
	
	
	public static void main(String[] args)
	{
		Rysunki r = new Rysunki(15,20);
		int x=3;
		int y=2;
		
		r.dodajFigure(new Okrag());
		r.wyswietl();
		System.out.println();
		
		r.maxPole();
		System.out.println();
		
		r.wyswietlOkregi();
		System.out.println();
		
		r.wyswietlProstokaty();
		System.out.println();
		
		System.out.println("Kwadratów jest: "+r.ileKwadratow());		
		System.out.println("Punkt ("+x+","+y+") nalezy do: "+r.doIluOkregow(x,y)+" Okregow");
		


		
	}
	
	
	
}
