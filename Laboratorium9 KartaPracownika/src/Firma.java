import java.util.*;
import java.io.*;

public class Firma {
	
	private Wyplata[] wtab = new Wyplata[100];
	//private Wyplata dostepowa = new Wyplata();
	//Wyplata.setNumerWyplaty(0);
	//private int n;
	public Firma()
	{
		for(int i=0;i<wtab.length;i++)
		{
			wtab[i]=null;
		}
	}
	
	public void wyswietlanieMenu()
	{
		System.out.println("Menu: ");
		System.out.println("1: Wstawianie do tablicy kilka wyplat z roznymi kartami");
		System.out.println("2: Wyswietlanie utworzonych wyplat");
		System.out.println("3: Dodanie jednej wyplaty");
		System.out.println("4: Policzenie ile bylo wyplat z KartaKierownika");
		System.out.println("5: Wyswietlanie pracownika z KartaPersonelu, z którego wyplata byla najnizsza");
		System.out.println("6: Zapisanie do pliku tekstowego wyplat z uzyciem KartyPersonelu");
		System.out.println("7: Zakoncz dzialanie programu");
		
	}
	public void dodajWyplaty(double pensja, KartaPracownika karta)
	{
		if(Wyplata.getNumerWyplaty()<wtab.length)
		{
			wtab[Wyplata.getNumerWyplaty()]=new Wyplata(pensja, karta);
		}
		else
		{
			Wyplata[] tmp = new Wyplata[wtab.length+1];
			for(int i=0;i<Wyplata.getNumerWyplaty();i++)
			{
				tmp[i]=wtab[i];
			}
			
			tmp[Wyplata.getNumerWyplaty()]=new Wyplata(pensja, karta);
			wtab=tmp;
		}
	}
	public void dodanieWieluWyplat(int ile)
	{
		Random g = new Random();
		for(int i=0;i<ile;i++)
		{
			dodajWyplaty(Math.round(g.nextDouble()*200000)/100.00,zwrocLosowaKarte());
		}
	}
	public KartaPracownika zwrocLosowaKarte()
	{
		Random g = new Random();
		int a=g.nextInt(3);
		KartaPracownika wynik=null;
		switch(a)
		{
		case 0:
			wynik=new KartaKierownika(g.nextInt(30),"Kowalski");
			break;
		case 1:
			wynik=new KartaDyrektora(g.nextInt(30),"Nowak");
			break;
		case 2:
			wynik=new KartaPersonelu(g.nextInt(30),"Zawadzki");
			break;
		default:
			break;
		}
		return wynik;
	}
	public void wyswietlWyplaty()
	{
		for(int i=0;i<Wyplata.getNumerWyplaty();i++)
		{
			System.out.println(i+": "+wtab[i]);
		}
	}
	public int ileWyplatZKartyKierownika()
	{
		int wynik=0;
		
		for(int i=0;i<Wyplata.getNumerWyplaty();i++)
		{
			if(wtab[i].getKarta() instanceof KartaKierownika)
			{
				wynik++;
			}
		}
		
		return wynik;
	}
	public void wyswietlaniePracownikaNajnizsza()
	{
		KartaPracownika minKarta = null;
		KartaPracownika tmpKarta;
		double minPensja=0;
		double tmpPensja;
		boolean pierwszy=true;
		
		for(int i=0;i<Wyplata.getNumerWyplaty();i++)
		{
			tmpKarta=wtab[i].getKarta();
			tmpPensja=wtab[i].getPensja();
			
			if(tmpKarta instanceof KartaPersonelu)
			{
				if(pierwszy)
				{
					minKarta=tmpKarta;
					minPensja=tmpPensja;
					pierwszy=false;
				}
				if(tmpPensja<minPensja)
				{
					minKarta=tmpKarta;
					minPensja=tmpPensja;
				}
			}
		}
		
		System.out.println(minKarta+": "+minPensja);
	}
	public void zapisDoPliku(String nazwaPliku)
	{	
		File plik = new File(nazwaPliku);
		try( BufferedWriter bwriter = new BufferedWriter(new FileWriter(plik)))
		{
			for(int i=0;i<Wyplata.getNumerWyplaty();i++)
			{
				if(wtab[i].getKarta() instanceof KartaPersonelu)
				{
					bwriter.write(wtab[i].toString());
					bwriter.write("\n");
				}
			}	
		}catch(IOException e)
		{
			System.out.println("Nie mozna zapisać do pliku");
			return;
		}
		System.out.println("Sukces");
	}
	
	public static void main(String[] args) {
		Firma firma = new Firma();
		Scanner s = new Scanner(System.in);
		
		int wybor;
		double pensja;
		boolean petla=true;
		String sciezkaDoPliku;
		
		while(petla)
		{
			firma.wyswietlanieMenu();
			wybor=s.nextInt();
			
			switch(wybor)
			{
			case 1:
				System.out.println("Podaj ile: ");
				firma.dodanieWieluWyplat(s.nextInt());
				System.out.println("Sukces");
				break;
			case 2:
				firma.wyswietlWyplaty();
				break;
			case 3:
				System.out.println("Podaj pensje: ");
				pensja=Math.round(s.nextDouble()*100)/100.00;
				firma.dodajWyplaty(pensja, firma.zwrocLosowaKarte());
				break;
			case 4:
				System.out.println("Bylo: "+firma.ileWyplatZKartyKierownika()+" wyplat z KartaKierownika");
				break;
			case 5:
				firma.wyswietlaniePracownikaNajnizsza();
				break;
			case 6:
				/*Ścieżka katalogu, w którym ma być zapisany plik
				  aby działało eclipse musi mieć odpowiednie uprawnienia
				  do katalogu/pliku
				*/
				System.out.println("Podaj lokalizacje pliku końcowego: ");
				sciezkaDoPliku=s.next();
				firma.zapisDoPliku(sciezkaDoPliku);
				break;
			case 7:
				System.out.println("Koniec");
				petla=false;
				break;
			}
		}
		s.close();
	}

}
