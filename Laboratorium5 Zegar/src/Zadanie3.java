import java.util.Scanner;

public class Zadanie3 {

	public static void wyswietl(int [][] tab)
	{
		//int k=tab[tab.length-1][tab[tab.length-1].length-1];
		//int cyfry=ileCyfr(k);
		//String tmp;
		//int dlugoscWiersza=9;
		for(int i=0;i<tab.length;i++) {
			for(int j=0;j<tab[i].length;j++)
			{
			//	tmp=""+tab[i][j];
				//tmp=dopiszZera(tmp,cyfry);
				System.out.printf("%3d ",tab[i][j]);
			}
			System.out.println();
		}
	}
	public static int ileCyfr(int k)
	{
		int wynik=0;
		while(k>0)
		{
			wynik++;
			k/=10;
		}
		return wynik;
	}
	public static void przypisanie(int [][] tab)
	{
		//Przypisywanie wartości 
		int k=1;
		for(int i=0;i<tab.length;i++) 
		{
			for(int j=0;j<tab[i].length;j++)
			{
				tab[i][j]=k;
				k++;
			}
		}
		
	}
	public static String dopiszZera(String a, int cyfry)
	{
		while(a.length()<cyfry)
		{
			a="0"+a;
		}
		return a;
	}
	public static void alokacja(int [][] tab)
	{
		//Dynamiczna alokacja "drugiego wymiaru" tablicy
		for(int i=0;i<tab.length;i++)
		{
			tab[i] = new int[i+1];
		}
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int[][] tab = new int[n][];
		
		
		alokacja(tab);
		przypisanie(tab);
		wyswietl(tab);
		
		scan.close();
	}

}
