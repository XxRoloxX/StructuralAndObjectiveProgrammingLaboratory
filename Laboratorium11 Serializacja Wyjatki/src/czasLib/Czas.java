package czasLib;

public class Czas {
    static final long SDZIEN=60*60*24;
    static final long SGODZINA=3600;
    
	public static int ileDniWMiesiacu(int mies, int rok)
	{
		int wynik=0;
		switch(mies)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			wynik=31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			wynik=30;
			break;
		case 2:
			if(czyPrzestepny(rok))
			{
				wynik=29;
			}
			else
			{
				wynik=28;
			}
		
			
		}
		return wynik;
	}
	public static boolean CzyPrzedOstatnimDniemMiesiaca(long s, int dzienTyg)
	{
		int []data = ZwrocDate(s);
		for(int i=data[0];i<=ileDniWMiesiacu(data[1],data[2]);i++)
		{
			if(data[6]==dzienTyg)
			{
				return true;
			}
			data[6]++;
			data[6]%=7;
		}
		return false;
	}
	public static int OstatniDzienMiesiaca(long s, int dzienTyg)
	{
		int[] data = ZwrocDate(s);
		int wynik=0;
		
		for(int i=data[0];i>=1;i--)
		{
			data[6]--;
			data[6]%=7;
		}
		
		for(int i=1;i<=ileDniWMiesiacu(data[1],data[2]);i++)
		{
			if(data[6]==dzienTyg)
			{
				wynik=i;
			}
			
			data[6]++;
			data[6]%=7;
			
		}
		return wynik;
	}
	public static int NDzienMiesiaca(long s, int dzienTyg, int n)
	{
		int[] data = ZwrocDate(s);
		int wynik=0;
		int tmpN=0;
		
		for(int i=data[0];i>=1;i--)
		{
			data[6]--;
			data[6]%=7;
		}
		
		for(int i=1;i<=ileDniWMiesiacu(data[1],data[2]);i++)
		{
			if(data[6]==dzienTyg)
			{
				tmpN++;
				if(tmpN==n)
				{
					wynik=i;
					break;
				}
			}
			
			data[6]++;
			data[6]%=7;
			
		}
		return wynik;
	}
	public static boolean CzyPrzedNDniemMiesiaca(long s, int dzienTyg, int n)
	{
		int [] data = ZwrocDate(s);
		int tmpN=0;
		
		for(int i=data[0];i>=1;i--)
		{
			if(data[6]==dzienTyg)
			{
				tmpN++;
			}
			data[6]--;
			data[6]%=7;
		}
		
		if(tmpN<n)
		{
			return true;
		}
		
		return false;
	}
	public static String format2(int n)
	{
		String wynik=""+n;
		if(n<10)
		{
			wynik="0"+wynik;
		}
		return wynik;
	}
	public static int ileDniWRoku(int rok)
	{
		int wynik=0;
		for(int i=1;i<=12;i++)
		{
			wynik+=ileDniWMiesiacu(i,rok);
		}
		return wynik;
	}
	public static long ileSekundWMiesiacu(int m, int rok)
	{
		return ileDniWMiesiacu(m, rok)*SDZIEN;
	}
	public static long ileSekundWRoku(int rok)
	{
		long wynik=0;
		
		for(int i=1;i<=12;i++)
		{
			wynik+=ileSekundWMiesiacu(i,rok);
		}
		
		return wynik;
	}
	public static boolean czyPrzestepny(int rok)
	{
		if((rok%4==0 && rok%100!=0) || rok%400==0)
		{
			return true;
		}
		
		return false;
	}
	public static long ZwrocSekundy(int dzien, int mies, int rok,int godz, int min, int sek)
	{
		int r1=1970;
		int m1=1;
		int d1=1;
		int g1=0;
		int min1=0;
		long wynik=0;
		
		for(int i=r1;i<rok;i++)
		{
			wynik+=ileSekundWRoku(i);
		}
		for(int i=m1;i<mies;i++)
		{
			wynik+=ileSekundWMiesiacu(i,rok);
		}
		for(int i=d1;i<dzien;i++)
		{
			wynik+=SDZIEN;
		}
		for(int i=g1;i<godz;i++)
		{
			wynik+=SGODZINA;
		}
		for(int i=min1;i<min;i++)
		{
			wynik+=60;
		}
		wynik+=sek;
		
		return wynik;
				
	}
	public static int[] ZwrocDate(long s)
	{
		int tab[] = {1,1,1970,0,0,0,3};
		//tab[]={dzien, miesiac, rok, godzina, minuta, sekunda, dzienTygodnia}
		long sekundyWRokuTmp;
		long sekundyWMiesiacuTmp;
		while(s>0)
		{
			sekundyWRokuTmp=ileSekundWRoku(tab[2]);
			sekundyWMiesiacuTmp=ileSekundWMiesiacu(tab[1],tab[2]);
			
			if(sekundyWRokuTmp<=s)
			{
				s-=sekundyWRokuTmp;
				tab[6]+=ileDniWRoku(tab[2]);
				tab[6]%=7;
				tab[2]++;
			}
			else if(sekundyWMiesiacuTmp<=s)
			{
				s-=sekundyWMiesiacuTmp;
				tab[6]+=ileDniWMiesiacu(tab[1],tab[2]);
				tab[6]%=7;
				tab[1]++;

			}
			else if(SDZIEN<=s)
			{
				s-=SDZIEN;
				tab[6]+=1;
				tab[6]%=7;
				tab[0]++;
			}
			else if(SGODZINA<=s)
			{
				s-=SGODZINA;
				tab[3]++;
			}
			else if(60<=s)
			{
				s-=60;
				tab[4]++;
			}
			else
			{
				tab[5]+=s;
				s=0;
			}
		}
		
		return tab;
	}

}
