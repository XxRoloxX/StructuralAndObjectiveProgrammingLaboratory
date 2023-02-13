import java.util.Scanner;
public class Zadanie1 {
	public static double e_x(double x) {
		double sum=1;
		int k=1;
		double w=1;
		double EPS=0.0001;
		
		while(Math.abs(w)>=EPS) {
			w=w*x/(double)k;
			k++;
			sum+=w;
		}
		
		return sum;
	}
	public static double iloczyn(int n, double x) {
		double product=1;
		long silnia=1;
		
		
		for(int i=1;i<=n;i++)
		{
			silnia*=i;
			product=product*(x+i)/(double)silnia;
				
		}
		
		return product;
	}
	public static double S(int n, double x) {
		if(x<-2)
		{
			return e_x(x);
		}
		else if(x<=0) 
		{
			return 4.0/5.0;
		}
		else
		{
			return iloczyn(n,x);
		}
	}

	public static void main(String[] args) {
		
		String tmp;
		String decyzja=" ";
		double x=0;
		int n=0;
		Scanner scan = new Scanner(System.in);
		boolean stop=false;
		
		while(!stop){
			try {
			
				System.out.print("Podaj n: ");
				n=scan.nextInt();
		
				while(n<1)
				{
					System.out.print("N musi należeć do liczb naturalnych ! \nPodaj n: ");
					n=scan.nextInt();
				}
		
				System.out.print("\nPodaj x: ");
				x=scan.nextDouble();
		
				System.out.println("\nWynik funkcji: "+S(n,x)+"\n");	
				
			}catch(java.util.InputMismatchException e) {
				System.out.println("Niepoprawny typ danych: "+e);
		}
			
			//usunięcie z wejścia standardowego pustego łańcucha
			tmp=scan.nextLine();
			
			System.out.print("Czy zakończyć ? (T/t)");
			decyzja=scan.nextLine();
			
			if(decyzja.equals("T") || decyzja.equals("t"))
			{
				stop=true;
			}
			
		}
		
		scan.close();
	}

}
