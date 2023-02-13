package strefaCzasowa;
import czasLib.Czas;
import java.io.*;

public class ZmianaCzasuUS implements ZmianaCzasuInterfejs,Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1506601390876744084L;

	public int zmianaCzasuLetni(long s)
	{
		//Czas letni obowiazuje od drugiej niedzieli Marca o 2:00
		//do pierwszej niedzieli listopada o 2:00
		int []data = Czas.ZwrocDate(s);
		int wynik=0;
		int godzinaZmiany=2;
		
		if(data[1]>3 && data[1]<11)
		{
			wynik=1;
		}
		else if(data[1]==3)
		{
			if(data[0]>Czas.NDzienMiesiaca(s, 6, 2))
			{
				wynik=1;
			}
			else if(data[0]==Czas.NDzienMiesiaca(s, 6, 2))
			{
				if(data[3]>=godzinaZmiany)
				{
					wynik=1;
				}
			}
		}
		else if(data[1]==11)
		{
			if(data[0]<Czas.NDzienMiesiaca(s, 6, 1))
			{
				wynik=1;
			}
			else if(data[0]==Czas.NDzienMiesiaca(s, 6, 1))
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
