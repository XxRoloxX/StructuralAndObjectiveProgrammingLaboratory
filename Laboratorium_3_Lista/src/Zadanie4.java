
public class Zadanie4 {
	public static void RysowanieDiamentu(int r) {
		
		int k=0;
		int z=1;
		
		for(int i=0;i<2*r;i++)
		{
			if(i<r)
			{
				k=i;
			}
			else
			{
				k=k-1;
			}
			
			for(int j=0;j<2*r;j++)
			{
				if(j<=r+k && j>=r-k) {
					
					if(z%2==0)
					{
						System.out.print(" ");
					}
					else {
						System.out.print("*");
					}
					
					z++;
				}
				else
				{
					System.out.print(" ");
				}
				
			}
			System.out.println();
			
			z=1;
		}
	}
	public static void RysowanieKola(double r) {
		
		for(int i=0;i<2*r;i++)
		{
			for(int j=0;j<2*r;j++)
			{
				if(Math.sqrt((i-r)*(i-r) + (j-r)*(j-r))<r)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
			
		}
		
	}
	
		
	
	
	
	public static void main(String[] args) {
		
		//Rysowane są dwie różne figury, ponieważ nie wiem,
		//która z figur jest bardziej "zaawansowana"

		
		RysowanieDiamentu(10);
		RysowanieKola(10);


		
		
	}
}
