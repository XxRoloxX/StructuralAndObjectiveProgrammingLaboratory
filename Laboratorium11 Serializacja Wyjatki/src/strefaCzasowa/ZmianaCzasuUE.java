package strefaCzasowa;
import czasLib.*;
import java.io.*;

public class ZmianaCzasuUE implements ZmianaCzasuInterfejs,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8218708099654855007L;

	//Zwraca 1 kiedy jest zmiana czasu i 0 kiedy jej nie ma
	public int zmianaCzasuLetni(long s)
	{
		int wynik=0;
		int[] data = Czas.ZwrocDate(s);
		//Jezeli data jest od ostatniej niedzieli o 1:00
		//marca do ostatniej niedzieli pazdziernika o 1:00
		int godzinaZmiany=1;
		
		if(data[1]>3 && data[1]<10)
		{
			wynik=1;
		}
		else if(data[1]==3)
		{
			if(data[0]>Czas.OstatniDzienMiesiaca(s,6))
			{
				wynik=1;
			}
			else if(data[0]==Czas.OstatniDzienMiesiaca(s,6))
			{
				if(data[3]>=godzinaZmiany)
				{
					wynik=1;
				}
			}
		}
		else if(data[1]==10)
		{
			if(data[0]<Czas.OstatniDzienMiesiaca(s,6))
			{
				wynik=1;
			}
			else if(data[0]==Czas.OstatniDzienMiesiaca(s,6))
			{
				if(data[3]<godzinaZmiany)
				{
					wynik=1;
				}
			}
		}
		
		return wynik;
	}
	

}
