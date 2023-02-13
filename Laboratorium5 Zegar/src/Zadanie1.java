class Zegar{
	private int sekundy;
	public Zegar() {
		sekundy=0;
	}
	public Zegar(int hh, int mm, int ss)
	{
		sekundy=hh*3600 + mm*60 + ss;	
		if(czyPelnyObrot())
		{
			pelnyObrot();
		}
	}
	public void pelnyObrot()
	{
		//24*3600 = 86400
		sekundy%=86400;

	}
	public boolean czyPelnyObrot()
	{
		//24*3600 = 86400
		if(sekundy>=86400)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean czyPoprawnaGodzina(int hh, int mm, int ss)
	{
		if(hh>=0 && hh<24 && mm>=0 && mm<60 && ss>=0 && ss<60) {
			return true;
		}
		else
		{
			return false;
		}
	}
	public void setSekundy(int s)
	{
		sekundy=s;
	}
	public int getSekundy() {
		return sekundy;
	}
	public void Przesun(int hh, int mm, int ss)
	{
		sekundy+= hh*3600 + mm*60 + ss;
		if(czyPelnyObrot())
		{
			pelnyObrot();
		}
	}
	public static String FormatowanieLiczby(int a)
	{
		if(a<10)
		{
			return "0"+a;
		}
		else
		{
			return ""+a;
		}
	}
	public void Wypisz()
	{
		int sekundy_kopia=sekundy;
		int hh=sekundy_kopia/3600;
		sekundy_kopia%=3600;
		int mm=sekundy_kopia/60;
		sekundy_kopia%=60;
		
		System.out.print(sekundy+" sekund.\nGodzina: ");
		System.out.println(FormatowanieLiczby(hh)+":"+
		FormatowanieLiczby(mm)+":"+FormatowanieLiczby(sekundy_kopia));
	}
	
}
public class Zadanie1 {

	public static void main(String[] args) {
		Zegar ob1 = new Zegar(25,70,1);
		ob1.Wypisz();
		ob1.Przesun(1, 1, 1);
		ob1.Wypisz();
	}

}
