package formatyDaty;
import czasLib.Czas;
import java.io.*;

public class dd__mm__rrrr implements DataInterfejs,Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = -889017551697925486L;

		public void wyswietl(long s)
		{
			int[] data = Czas.ZwrocDate(s);
			System.out.printf("%2s.%2s.%4d",Czas.format2(data[0]),Czas.format2(data[1]),data[2]);
		}

}
