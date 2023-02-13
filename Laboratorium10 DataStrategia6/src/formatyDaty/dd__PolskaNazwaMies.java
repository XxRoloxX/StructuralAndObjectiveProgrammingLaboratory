package formatyDaty;
import czasLib.Czas;
import java.io.*;

public class dd__PolskaNazwaMies implements DataInterfejs,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2880399026669502923L;

	public void wyswietl(long s)
	{
		String[] nazwy= {"Styczen", "Luty", "Marzec","Kwiecien","Maj","Czerwiec",
				"Lipiec","Sierpien","Wrzesien","Pazdziernik","Listopad", "Grudzien"};
		
		int[] data = Czas.ZwrocDate(s); 
		System.out.printf("%2d %s",data[0],nazwy[data[1]-1]);

		
	}

}
