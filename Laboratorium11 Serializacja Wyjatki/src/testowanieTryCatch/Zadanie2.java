package testowanieTryCatch;
import java.io.*;

public class Zadanie2 {
	
	public static void GenerowanieIndex(int []tab)
	{
		try {
			
			System.out.println(tab[tab.length]);
			
		}catch(ArrayIndexOutOfBoundsException e)
		{
		}
	}
	public static void GenerewanieArithmetic()
	{
		try {
			System.out.println(3/0);
		}catch(ArithmeticException e)
		{
		}
	}
	public static void RzucanieIndex(int []tab) throws ArrayIndexOutOfBoundsException
	{
			
			System.out.println(tab[tab.length]);
	}	

	public static void RzucanieArithmetic() throws ArithmeticException
	{
		System.out.println(3/0);
	}
	public static long[] SprawdzArithmeticDla(int n)
	{
		{
			long l1_2=0,l2_2=0,l1_1=0,l2_1=0;
			long l1,l2;
			long[] tabl = new long[2];
			
			l1_1=System.nanoTime();
			for(int i=0;i<n;i++)
			{
				GenerewanieArithmetic();
			}
			l1_2=System.nanoTime();
			
			l2_1=System.nanoTime();
			for(int i=0;i<n;i++)
			{
				try {
				RzucanieArithmetic();
				}catch(ArithmeticException e)
				{
					//System.out.println("Wylapano wyjatek arytmetyczny !");
				}
			}
			l2_2=System.nanoTime();
			
			l1=l1_2-l1_1;
			l2=l2_2-l2_1;
			
			tabl[0]=l1;
			tabl[1]=l2;
			
			System.out.println("Czas dla przechwytywania w metodzie: "+l1);
			System.out.println("Czas dla rzucania poza metode: "+l2);
			System.out.println("Różnica: Przechwytywanie  - Rzucanie: "+(l1-l2)+" nanosekund");
			return tabl;
		}
		
	}
	public static long[] SprawdzIndexDla(int n)
	{
		long l1_2=0,l2_2=0,l1_1=0,l2_1=0;
		long l1,l2;
		long[] tabl = new long[2];
		int[] tab= {1,2,3};
		
		l1_1=System.nanoTime();
		for(int i=0;i<n;i++)
		{
			GenerowanieIndex(tab);
		}
		l1_2=System.nanoTime();
		
		l2_1=System.nanoTime();
		
		for(int i=0;i<n;i++)
		{
			try {
			RzucanieIndex(tab);
			}catch(IndexOutOfBoundsException e)
			{
			}
		}
		l2_2=System.nanoTime();
		
		l1=l1_2-l1_1;
		l2=l2_2-l2_1;
		
		tabl[0]=l1;
		tabl[1]=l2;
		
		System.out.println("Czas dla przechwytywania w metodzie: "+l1);
		System.out.println("Czas dla rzucania poza metode: "+l2);
		System.out.println("Różnica: Przechwytywanie  - Rzucanie: "+(l1-l2)+" nanosekund");
		return tabl;
	}
	public static void main(String[] args)
	{
		long[] tab;
		try(BufferedWriter br = new BufferedWriter(new FileWriter(new File("dane.txt"))))
		{
			br.write("Iteracje;CzasDlaIndexGenerowanie;CzasDlaIndexRzucanie;CzasDlaArithmeticGenerowanie;CzasDlaArithmeticRzucanie\n");
			SprawdzIndexDla(10000);
		for(int i=100;i<=10000;i*=10)
		{
			System.out.println("Czas dla IndexOutOfBoundException dla n="+i);
			tab=SprawdzIndexDla(i);
			br.write(i+";"+tab[0]+";"+tab[1]);
			System.out.println("Czas dla ArithmeticException dla n="+i);	
			tab=SprawdzArithmeticDla(i);
			br.write(";"+tab[0]+";"+tab[1]);
			br.write("\n");
			System.out.println();

		}
		}catch(IOException e){
		System.out.println("Błąd"+e);
	}
}
}
