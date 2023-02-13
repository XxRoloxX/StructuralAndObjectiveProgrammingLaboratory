
public class Zadanie3BezScannera {
	/*Wersja programu bez interaktywnego przyjmowania argumentów od
	 użytkownika. W projekcie jest również dostępna wersja programu
	 z użyciem obiektu klasy Scanner do przyjmowania argrumentów od użytkownika*/
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
		char znak='K';
		//Promień Kuli
		double R=9.8;
		//Długości krawędzi prostopadłościanu
		double a=10,b=9,c=1.5;
		
		System.out.println("Wybierz jedną z pozycji: ");
		System.out.println("\'K\': Kula");
		System.out.println("\'P\': Prostopadłościan");
		System.out.println("\'S\': Stop");
		
		switch(znak)
		{
			case 'K':
				System.out.printf("Pole kuli wynosi: %.2f %n",Pole_Kuli(R));
				System.out.printf("Objętość kuli wynosi: %.2f %n",Objetosc_Kuli(R));
				break;
				
			case 'P':
				System.out.println("Pole prostopadłościanu wynosi: "+Pole_Prostopadloscianu(a,b,c));
				System.out.println("Objętość prostopadłościanu wynosi: "+Objetosc_Prostopadloscianu(a,b,c));
				break;
				
			case 'S':
				System.out.println("Koniec programu");
				break;
			default:
				System.out.println("Niepoprawna opcja");
		}

	}

}
