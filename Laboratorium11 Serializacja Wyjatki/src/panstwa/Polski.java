package panstwa;
import formatyDaty.*;
import opisy.Algorytm;
import formatyGodziny.*;
import strefaCzasowa.*;

public class Polski extends Data {
	
	public Polski()
	{
		super();
		gInterfejs = new gg24_mm_ss();
		dInterfejs = new dd__mm__PolskiDzienTygodnia();
		zInterfejs = new ZmianaCzasuUE();
		strefaCzasowa=1;
		
		setFormatGodzinyInfo(Algorytm.opisZmianyGodzinyGG24_MM_SS);
		setFormatDatyInfo(Algorytm.opisZmianyDatyDD__MM__PolskiDzienTygodnia);
		setZmianaCzasuInfo(Algorytm.opisZmianyCzasuUE);

	}
	public Polski(long s)
	{
		super(s);
		gInterfejs = new gg24_mm_ss();
		dInterfejs = new dd__mm__PolskiDzienTygodnia();
		zInterfejs = new ZmianaCzasuUE();
		strefaCzasowa=1;
		setFormatGodzinyInfo(Algorytm.opisZmianyGodzinyGG24_MM_SS);
		setFormatDatyInfo(Algorytm.opisZmianyDatyDD__MM__PolskiDzienTygodnia);
		setZmianaCzasuInfo(Algorytm.opisZmianyCzasuUE);
	}
	public Polski(long s, DataInterfejs d, GodzinaInterfejs g, ZmianaCzasuInterfejs z)
	{
		super(s,d,g,z);
		setFormatGodzinyInfo(Algorytm.opisZmianyGodzinyGG24_MM_SS);
		setFormatDatyInfo(Algorytm.opisZmianyDatyDD__MM__PolskiDzienTygodnia);
		setZmianaCzasuInfo(Algorytm.opisZmianyCzasuUE);
	}

}
