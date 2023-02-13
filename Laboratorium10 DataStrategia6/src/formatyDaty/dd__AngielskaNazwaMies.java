package formatyDaty;
import czasLib.Czas;
import java.io.*;

public class dd__AngielskaNazwaMies implements DataInterfejs, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4893495284822644939L;


	public void wyswietl(long s)
	{
		int[] data = Czas.ZwrocDate(s);
		String[] nazwy= {"January", "February","March","April","May","June","July"
				,"August","September","October","November","December"};
		
		System.out.printf("%2s %s",Czas.format2(data[0]),nazwy[data[1]-1]);
		
	}
}
