import java.util.Scanner;
import java.util.Random;


public class Zadanie2 {
	public static void wyswietlanie(int [] tab)
	{
		
		for(int i=0;i<tab.length;i++)
		{
			System.out.print(tab[i]+",");
		}
		System.out.println();
	}
	public static int najmniejsza(int [] tab)
	{
		int MN=tab[0];
		for(int i=1;i<tab.length;i++)
		{
			if(tab[i]<MN)
			{
				MN=tab[i];
			}
		}
		
		return MN;
	}
	public static int ileNieparzystych(int [] tab)
	{
		int wynik=0;
		for(int i=0;i<tab.length;i++)
		{
			if(tab[i]%2!=0)
			{
				wynik++;
			}
		}
		return wynik;
	}
	public static long iloczynNieparzystych(int [] tab)
	{
		long wynik=1;
		boolean czyIstnieje=false;
		
		for(int i=0;i<tab.length;i++)
		{
			if(tab[i]%2!=0)
			{
				wynik*=tab[i];
				czyIstnieje=true;
			}
		}
		if(!czyIstnieje)
		{
			wynik=0;
		}
		return wynik;
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random g = new Random();
		int x;
		int n=-1;
		int[] tab;
		
		System.out.print("Podaj n: ");
		n=scan.nextInt();
		
		while(n>0)
		{
			tab = new int[n];
			
			for(int i=0;i<n;i++)
			{
				x=g.nextInt(50);
				tab[i]=x;
			}
			
			System.out.println(tab.length);
			System.out.print("Tablica: ");
			wyswietlanie(tab);
			System.out.println("Najmniejszy element: "+najmniejsza(tab));
			System.out.println("Iloczyn nieparzystych: "+iloczynNieparzystych(tab));
			System.out.println("Liczba nieparzystch: "+ileNieparzystych(tab));
			
			System.out.print("Podaj n: ");
			n=scan.nextInt();
			tab=null;
		}
		
		scan.close();

	}

}
