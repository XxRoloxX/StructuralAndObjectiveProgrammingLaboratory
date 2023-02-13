package formatyDaty;
import czasLib.Czas;
import java.io.*;

public class dd__mm__PolskiDzienTygodnia implements DataInterfejs,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8026728282493421191L;

	public void wyswietl(long s)
	{
		int tab[] = Czas.ZwrocDate(s);
		String[] dniTygodnia = {"Poniedzialek","Wtorek","Sroda","Czwartek","Piatek"	,"Sobota","Niedziela"};	
		System.out.printf("%2s.%2s %s",Czas.format2(tab[0]),Czas.format2(tab[1]),dniTygodnia[tab[6]]);
		
	}
}
