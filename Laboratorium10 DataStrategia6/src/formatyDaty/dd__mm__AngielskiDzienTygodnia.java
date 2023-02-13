package formatyDaty;

import czasLib.Czas;
import java.io.*;

public class dd__mm__AngielskiDzienTygodnia implements DataInterfejs, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7397493204855488029L;

	public void wyswietl(long s)
	{
		int tab[] = Czas.ZwrocDate(s);
		String[] dniTygodnia = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};	
		System.out.printf("%2s.%2s %s",Czas.format2(tab[0]),Czas.format2(tab[1]),dniTygodnia[tab[6]]);
		
	}
	
}
