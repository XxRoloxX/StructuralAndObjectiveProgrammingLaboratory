package Wielomian;

public class Wielomian {
	public static double Hermite(double x, int n)
	{
		double first=1.0;
		double second=2.0*x;
		double third=0.0;
		
		if(n==0)
		{
			return first;
		}
		else if(n==1)
		{
			return second;
		}
		
		for(int i=2;i<=n;i++)
		{
			third=2*x*second - 2*(i-1)*first;
			first=second;
			second=third;
		}
		
		return third;
	}

}
