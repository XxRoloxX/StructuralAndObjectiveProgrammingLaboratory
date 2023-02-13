package DataObsluga;
import java.util.*;
import Serializacja.Serializacja;
import java.io.*;
import panstwa.*;
import formatyDaty.*;
import formatyGodziny.*;
import strefaCzasowa.*;
import czasLib.Czas;

public class DataObsluga {
	
	private Date now;
	private int rozmiar;
	private Data[] data;
	private Scanner scan;
	
	public DataObsluga()
	{
		now = new Date();
		rozmiar=0;
		scan = new Scanner(System.in);
		wyborPanstwa();
		
	}
	public DataObsluga(Data[] dt)
	{
		data=dt;
		scan = new Scanner(System.in);
		
		if(data!=null)
		{
			rozmiar=data.length;
			now=new Date();
		}
		else
		{
			rozmiar=0;
			wyborPanstwa();
		}
	}
	
	public static void pause(int ms)
	{
		try
		{
			Thread.sleep(ms);

		}catch(InterruptedException e)
		{
			System.out.println("Blad");
		}
	}
	public void wyborPanstwa()
	{
		int[] wybory = new int[10];
		int wybor;
		String StringWybor;
		String[] wyborTab;
		
		menuWyborPanstwa();
		/*
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
			StringWybor = br.readLine();
			wyborTab = StringWybor.split(" ");
			for(int i=0;i<wyborTab.length;i++)
			{
				wybory[i]=Integer.parseInt(wyborTab[i]);
			}
			rozmiar=wyborTab.length;
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		*/
		
		do{
			wybor=scan.nextInt();
			if(wybor!=-1)
			{
			wybory[rozmiar]=wybor;
			rozmiar++;
			}
		}while(wybor!=-1);
		scan.nextLine();
		
		
		
		data=new Data[rozmiar];
		
		for(int i=0;i<rozmiar;i++)
		{
			switch(wybory[i])
			{
				case 0:
					data[i] = new Polski(now.getTime());
					break;
				case 1:
					data[i] = new USA(now.getTime());
					break;
				case 2:
					data[i] = new UK(now.getTime());
					break;
			}
		}
	}
	public void wyborDaty()
	{
		int wybor;
		
		for(int i=0;i<data.length;i++)
		{
			menuWyborDaty(data[i]);
			wybor=scan.nextInt();
			
			switch(wybor)
			{
				case 0:
					break;
				case 1:
					data[i].setdInterfejs(new dd__mm__rrrr());
					break;
				case 2:
					data[i].setdInterfejs(new dd__mm__PolskiDzienTygodnia());
					break;
				case 3:
					data[i].setdInterfejs(new dd__PolskaNazwaMies());
					break;
				case 4:
					data[i].setdInterfejs(new dd__mm__AngielskiDzienTygodnia());
					break;
				case 5:
					data[i].setdInterfejs(new dd__AngielskaNazwaMies());
					break;
				default:
					System.out.println("Niedozwolona wartosc");
					break;
			
			}
		}
	}
	public Data[] getData() {
		return data;
	}

	public void setData(Data[] data) {
		this.data = data;
	}

	public void wyborGodziny()
	{
		int wybor;
		for(int i=0;i<data.length;i++)
		{
			menuWyborGodziny(data[i]);
			wybor=scan.nextInt();
			switch(wybor)
			{
				case 0:
					break;
				case 1:
					data[i].setgInterfejs(new gg24_mm_ss());
					break;
				case 2:
					data[i].setgInterfejs(new gg24_mm());
					break;
				default:
					System.out.println("Niedozwolona wartosc");
					break;

			}
		}
	}
	public void wyborStrefyCzasowej()
	{
		int wybor;
		String wybor2;
		
		for(int i=0;i<data.length;i++)
		{
			menuWyborStrefyCzasowej1(data[i]);
			wybor2=scan.next();
			if(wybor2.equals("Y") || wybor2.equals("y") )
			{
				menuWyborStrefyCzasowej2(data[i]);
				wybor=scan.nextInt();
				data[i].setStrefaCzasowa(wybor);
			}
			
		}
	}
	public void wyborZmianyCzasu()
	{
		int wybor;
		
		for(int i=0;i<data.length;i++)
		{
			menuWyboruZmianyCzasu(data[i]);
			wybor=scan.nextInt();
			switch(wybor)
			{
				case 0:
					break;
				case 1:
					data[i].setzInterfejs(new ZmianaCzasuUE());
					break;
				case 2:
					data[i].setzInterfejs(new ZmianaCzasuUS());
					break;
				case 3:
					data[i].setzInterfejs(new BezZmianyCzasu());
					break;
				default:
					System.out.println("Niedozwolona opcja");
					break;
					
			}			
			
		}
	}
	
	public static void menuWyborPanstwa()
	{
		System.out.println("Wybierz czas i format dla ");
		System.out.println(" 0:	Polska           ");
		System.out.println(" 1:	USA (GMT -5)     ");
		System.out.println(" 2:	Wielka Brytania  ");
	 	System.out.println("-1: Aby zakończyć wpisywanie");
	}
	public static void menuWyborDaty(Data dt)
	{
		System.out.println("Na co zmienic domyslny format daty dla "+dt.getClass().getSimpleName()+"?");
		System.out.println("0: Domyslny dla "+dt.getClass().getSimpleName()+" ("+dt.getdInterfejs().getClass().getSimpleName()+")");
		System.out.println("1: dd-mm-rrrr");
		System.out.println("2: dd-mm-PolskiDzienTygodnia");
		System.out.println("3: dd-PolskaNazwaMiesiaca");
		System.out.println("4: dd-mm-AngielskiDzienTygodnia");
		System.out.println("5: dd-AngielskaNazwaMiesiaca");
		
	}
	public static void menuWyborGodziny(Data dt)
	{
		System.out.println("Na co zmienic domyslny format godziny dla "+dt.getClass().getSimpleName()+"?");
		System.out.println("0: Domyslna dla "+dt.getClass().getSimpleName()+" ("+dt.getgInterfejs().getClass().getSimpleName()+")");
		System.out.println("1: gg24_mm_ss");
		System.out.println("2: gg24_m");
	}
	public static void menuWyborStrefyCzasowej1(Data dt)
	{
		System.out.println("Czy zmienić domyślną strefe czasową dla "+dt.getClass().getSimpleName()+"? Y/n");
		System.out.println("Domyslna strefa dla "+dt.getClass().getSimpleName()+" to:  UTC"+dt.getStrefaCzasowa()+":00)");
	}
	public static void menuWyborStrefyCzasowej2(Data dt)
	{
		System.out.println("Jaką strefę czasową ustawić dla "+dt.getClass().getSimpleName()+"?");
		System.out.println("Wpisz wartość w konwencji UTC: ");
	}
	public static void menuWyboruZmianyCzasu(Data dt)
	{
		System.out.println("Jaki system zmiany czasu na letni ustawić dla "+dt.getClass().getSimpleName());
		System.out.println("0: Domyslny dla "+dt.getClass().getSimpleName()+" ("+dt.getzInterfejs().getClass().getSimpleName()+")");
		System.out.println("1: Zmiana czasu w UE");
		System.out.println("2: Zmiana czasu dla USA");
		System.out.println("3: Bez zmiany czasu");
		
	}
	public void wyswietlanieTablicy()
	{
		Date now=new Date();
		scan.close();
	//	int[] tab = Czas.ZwrocDate(now.getTime()/1000);
	//	System.out.println(now.getTime()/1000);
	//	System.out.println(Czas.ZwrocSekundy(tab[0],tab[1],tab[2],tab[3],tab[4],tab[5]));
		while(true)
		{
			now = new Date();
			for(int i=0;i<rozmiar;i++)
			{
				data[i].setSekundy(now.getTime()/1000);
				data[i].wyswietl();
				System.out.println();
			//	System.out.println(data[i].getZmianaCzasuInfo());
			//	System.out.println(data[i].getFormatGodzinyInfo());
			//	System.out.println(data[i].getFormatDatyInfo());
			//	System.out.println();
				data[i].wyswietlinfo();
				System.out.printf("%n%n");
			}
				System.out.println();
				System.out.println();
				pause(1000);
		}
	}
	public void ZapisDoPliku(String nazwa)
	{
		Serializacja.SerializacjaDoPliku(data,nazwa);
	}
	public void ZapisDoPliku()
	{
		System.out.println("Wpisz nazwę pliku do ktorego zapisac obiekty: ");
		Serializacja.SerializacjaDoPliku(data,scan.nextLine());
	}
	
	public void OdczytZPliku(String nazwa)
	{
		data=Serializacja.OdczytZPliku(nazwa);
		rozmiar=data.length;
	}
	public void OdczytZPliku()
	{
		System.out.println("Wpisz nazwę pliku, z którego chcesz odczytać obiekty: ");
		data=Serializacja.OdczytZPliku(scan.nextLine());
		rozmiar=data.length;
	}
}
	
	
