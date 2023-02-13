package formatyGodziny;
import czasLib.Czas;
import java.io.*;


public class gg24_mm implements GodzinaInterfejs,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1886460467997495366L;

	public void wyswietl(long s)
	{
		int[] data = Czas.ZwrocDate(s); 
		System.out.printf("%2s:%2s",Czas.format2(data[3]),Czas.format2(data[4]));
	}

}
