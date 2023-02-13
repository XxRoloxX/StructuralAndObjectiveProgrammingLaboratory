package Prog;
import Wielomian.Wielomian;

public class Prog {

	public static void main(String[] args) {
		double x=4;
		int n=3;
		
		for(int i=0;i<=n;i++)
		{
		System.out.printf("%f %n",Wielomian.Hermite(x,i));
		}
	}

}
