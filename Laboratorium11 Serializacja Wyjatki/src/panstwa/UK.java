package panstwa;
import formatyDaty.*;
import formatyGodziny.*;
import opisy.Algorytm;
import strefaCzasowa.*;

public class UK extends Data {
	
	public UK()
	{
		super();
		dInterfejs=new dd__mm__AngielskiDzienTygodnia();
		gInterfejs=new gg24_mm_ss();
		zInterfejs=new ZmianaCzasuUE();
		strefaCzasowa=0;
		setFormatGodzinyInfo(Algorytm.opisZmianyGodzinyGG24_MM_SS);
		setFormatDatyInfo(Algorytm.opisZmianyDatyDD__MM__AngielskaDzienTygodnia);
		setZmianaCzasuInfo(Algorytm.opisZmianyCzasuUE);
	}
	public UK(long s)
	{
		super(s);
		dInterfejs=new dd__mm__AngielskiDzienTygodnia();
		gInterfejs=new gg24_mm_ss();
		zInterfejs=new ZmianaCzasuUE();
		strefaCzasowa=0;
		setFormatGodzinyInfo(Algorytm.opisZmianyGodzinyGG24_MM_SS);
		setFormatDatyInfo(Algorytm.opisZmianyDatyDD__MM__AngielskaDzienTygodnia);
		setZmianaCzasuInfo(Algorytm.opisZmianyCzasuUE);
	}
	public UK(long s, DataInterfejs d, GodzinaInterfejs g, ZmianaCzasuInterfejs z)
	{
		super(s,d,g,z);
		setFormatGodzinyInfo(Algorytm.opisZmianyGodzinyGG24_MM_SS);
		setFormatDatyInfo(Algorytm.opisZmianyDatyDD__MM__AngielskaDzienTygodnia);
		setZmianaCzasuInfo(Algorytm.opisZmianyCzasuUE);
	}


}
