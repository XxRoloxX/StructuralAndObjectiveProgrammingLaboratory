import java.util.Random;

public class Main2 {
	public static void wyswietl(Towar[] sklep)
	{
		for(int i=0;i<sklep.length;i++)
		{
			sklep[i].getStan();
		}
	}
	public static Towar maxCena(Towar[] sklep)
	{
		double MAX=sklep[0].getCena();
		double cena;
		Towar najdrozszy=sklep[0];
		
		for(int i=1;i<sklep.length;i++)
		{
			cena=sklep[i].getCena();
			
			if(cena>MAX)
			{
				MAX=cena;
				najdrozszy=sklep[i];
			}
		}
		
		return najdrozszy;
	}
	public static int maxCena2(Towar[] sklep)
	{
		double MAX=sklep[0].getCena();
		double cena;
		int indxMAX=0;
		Towar najdrozszy=sklep[0];
		
		for(int i=1;i<sklep.length;i++)
		{
			cena=sklep[i].getCena();
			
			if(cena>MAX)
			{
				MAX=cena;
				najdrozszy=sklep[i];
				indxMAX=i;
			}
		}
		
		return indxMAX;
	}

	public static void main(String[] args) {
		int n=6;
		Towar[] Sklep = new Towar[n];
		Random g = new Random();
		
		for(int i=0;i<Sklep.length;i++)
		{
			Sklep[i]= new Towar(g.nextInt(1000),Math.round(g.nextDouble()*10000)/100.0);
		}
		
		wyswietl(Sklep);
		System.out.print("Najdroższy towar to: ");
		maxCena(Sklep).getStan();
	}

}
