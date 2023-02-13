import java.util.Scanner;

public class Zadanie3 {
	/*Wersja programu z użyciem obiektu z klasy Scanner.
	 * W projekcie znajduje się również wersja programu
	 * bez interaktywnego przyjmowania argumentów od użytkownika*/
	
	public static double Pole_Kuli(double R) {
		
		return 4*Math.PI*R*R;
	}
	public static double Pole_Prostopadloscianu(double a, double b, double c) {
		return a*b*2 + a*c*2 + b*c*2;
	}
	public static double Objetosc_Kuli(double R)
	{
		return (4/3.00)*Math.PI*R*R*R;
	}
	public static double Objetosc_Prostopadloscianu(double a, double b, double c)
	{
		return a*b*c;
	}
	
	public static void main(String[] args) {
		String znak=" ";
		Scanner scan = new Scanner(System.in);
		double R;
		double a;
		double b;
		double c;
		
		while(!znak.equals("S"))
		{
			/*IF dodany na potrzebę obsłużenia sytuacji kiedy metoda NextLine() klasy Scanner
			  zwraca pusty łańcuch*/
			if(!znak.equals("")) {
			System.out.println("Wybierz jedną z pozycji: ");
			System.out.println("\'K\': Kula");
			System.out.println("\'P\': Prostopadłościan");
			System.out.println("\'S\': Stop");
			}
			
			znak=scan.nextLine();
			
			try {
			switch(znak) {
				case "K":
					System.out.print("Podaj promień: ");
					R=scan.nextDouble();
					/*Ze względu na to, że Pi nie jest wymierne stosowane jest
					  zaokrąglenie do dwóch miejsc po przecinku*/
					System.out.printf("Pole Kuli: %.2f %n",Pole_Kuli(R));
					System.out.printf("Objętość Kuli: %.2f %n",Objetosc_Kuli(R));
					break;
				case "P":		
					System.out.print("Podaj długości boku \'a\': ");
					a=scan.nextDouble();
					System.out.print("Podaj długości boku \'b\': ");
					b=scan.nextDouble();
					System.out.print("Podaj długości boku \'c\': ");
					c=scan.nextDouble();
					System.out.println("Pole Prostopadłościanu: "+Pole_Prostopadloscianu(a,b,c));
					System.out.println("Objętość Prostopadłościanu: "+Objetosc_Prostopadloscianu(a,b,c));
					break;
				case "S":
					System.out.println("Koniec programu");
					break;
				/*case "" jest wykorzystywany tylko z powodu użycia obiektu klasy Scanner
				  i został dodany w celu obsłużenia sytuacji kiedy metoda NextLine() zwraca pusty łańcuch*/
				case "":
					break;
				default:
					System.out.println("Niepoprawny znak: "+znak);
					break;		
		}
			}catch(java.util.InputMismatchException e) {
				//usuniecie niepoprawnego argumentu z wejścia standardowego
				System.out.println("Niepoprawny typ danych: "+e);
				scan.nextLine();
			}
			
			
			System.out.println();
			
			
			

			
			
	}
		scan.close();

}
}
