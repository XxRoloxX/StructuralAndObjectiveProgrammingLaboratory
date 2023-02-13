package panstwa;
import formatyDaty.*;
import formatyGodziny.*;
import opisy.Algorytm;
import strefaCzasowa.*;

public class USA extends Data{
	
	public USA()
	{
		super();
		dInterfejs=new dd__AngielskaNazwaMies();
		gInterfejs=new gg24_mm();
		zInterfejs=new ZmianaCzasuUS();
		strefaCzasowa=-5;
		setFormatGodzinyInfo(Algorytm.opisZmianyGodzinyGG24_MM);
		setFormatDatyInfo(Algorytm.opisZmianyDatyDD_AngielskaNazwaMies);
		setZmianaCzasuInfo(Algorytm.opisZmianyCzasuUS);
	}
	public USA(long s)
	{
		super(s);
		dInterfejs=new dd__AngielskaNazwaMies();
		gInterfejs=new gg24_mm();
		zInterfejs=new ZmianaCzasuUS();
		strefaCzasowa=-5;
		setFormatGodzinyInfo(Algorytm.opisZmianyGodzinyGG24_MM);
		setFormatDatyInfo(Algorytm.opisZmianyDatyDD_AngielskaNazwaMies);
		setZmianaCzasuInfo(Algorytm.opisZmianyCzasuUS);

	}
	public USA(long s, DataInterfejs d, GodzinaInterfejs g, ZmianaCzasuInterfejs z)
	{
		super(s,d,g,z);
		setFormatGodzinyInfo(Algorytm.opisZmianyGodzinyGG24_MM);
		setFormatDatyInfo(Algorytm.opisZmianyDatyDD_AngielskaNazwaMies);
		setZmianaCzasuInfo(Algorytm.opisZmianyCzasuUS);

	}

}
