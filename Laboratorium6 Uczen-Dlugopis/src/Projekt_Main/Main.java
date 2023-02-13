package Projekt_Main;
import Dlugopis.Dlugopis;
import java.util.Random;


public class Main {
	public static void wyswietl(Dlugopis[] piornik)
	{
		for(int i=0;i<piornik.length;i++)
		{
			System.out.printf("Długopis o indeksie=%d ",i);
			piornik[i].getStan();
		}
	}

	public static void main(String[] args) {
		int n=8;
		Dlugopis[] piornik = new Dlugopis[n];
		Random g = new Random();
		
		for(int i=0;i<piornik.length;i++)
		{
			piornik[i]=new Dlugopis(g.nextInt(4)+1);
		}
		
		piornik[2].wyjmijZPiornika();
		wyswietl(piornik);
		piornik[2].wlozDoPiornika();
		System.out.println();
		wyswietl(piornik);


		
	}

}
