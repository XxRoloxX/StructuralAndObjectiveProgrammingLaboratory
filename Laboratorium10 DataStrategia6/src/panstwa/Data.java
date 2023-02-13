package panstwa;
import formatyGodziny.*;
import java.io.*;
import formatyDaty.*;
import strefaCzasowa.*;
import czasLib.*;
import opisy.Algorytm;

public abstract class Data implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -58709940284234647L;
	protected long sekundy;
	protected GodzinaInterfejs gInterfejs;
	protected DataInterfejs dInterfejs;
	protected ZmianaCzasuInterfejs zInterfejs;
	protected int strefaCzasowa;
	
	protected String FormatDatyInfo;
	protected String FormatGodzinyInfo;
	protected String ZmianaCzasuInfo;
	
	


	
	public Data()
	{
		sekundy=0;
	}
	public Data(long s)
	{
		sekundy=s;
	}
	
	public Data(long s, DataInterfejs d, GodzinaInterfejs g, ZmianaCzasuInterfejs z)
	{
		sekundy=s;
		gInterfejs =g;
		dInterfejs =d;
		zInterfejs =z;
	}
	
	public void wyswietl()
	{
		dInterfejs.wyswietl(sekundy+(strefaCzasowa+zInterfejs.zmianaCzasuLetni(sekundy))*3600);
		System.out.print(" ");
		gInterfejs.wyswietl(sekundy+(strefaCzasowa+zInterfejs.zmianaCzasuLetni(sekundy))*3600);
	}
	public void wyswietlGodzine()
	{
		gInterfejs.wyswietl(sekundy+(strefaCzasowa+zInterfejs.zmianaCzasuLetni(sekundy))*3600);

	}
	public void wyswietlDate()
	{
		dInterfejs.wyswietl(sekundy+(strefaCzasowa+zInterfejs.zmianaCzasuLetni(sekundy))*3600);

	}
	public int zwrocElementDaty(int n)
	{
		int []tab = Czas.ZwrocDate(sekundy);
		return tab[n];
	}
	public long getSekundy() {
		return sekundy;
	}
	public void setSekundy(long sekundy) {
		this.sekundy = sekundy;
	}
	public GodzinaInterfejs getgInterfejs() {
		return gInterfejs;
	}
	public void setgInterfejs(GodzinaInterfejs gInterfejs) {
		this.gInterfejs = gInterfejs;
		updateFormatGodzinyInfo();
	}
	public DataInterfejs getdInterfejs() {
		return dInterfejs;
	}
	public void setdInterfejs(DataInterfejs dInterfejs) {
		this.dInterfejs = dInterfejs;
		updateFormatDatyInfo();
	}
	public ZmianaCzasuInterfejs getzInterfejs() {
		return zInterfejs;
	}
	public void setzInterfejs(ZmianaCzasuInterfejs zInterfejs) {
		this.zInterfejs = zInterfejs;
		updateZmianaCzasuInfo();
	}
	public int getStrefaCzasowa() {
		return strefaCzasowa;
	}
	public void setStrefaCzasowa(int strefaCzasowa) {
		this.strefaCzasowa = strefaCzasowa;
	}
	public void wyswietlinfo()
	{
		System.out.println("Format dla: "+this.getClass().getSimpleName());
		System.out.println("Format godziny: "+gInterfejs.getClass().getSimpleName());
		System.out.println("Format daty   : "+dInterfejs.getClass().getSimpleName());
		System.out.println("Zmiana czasu wedlug: "+zInterfejs.getClass().getSimpleName());
		System.out.println("Strefa czasowa: UTC"+strefaCzasowa);

	}
	
	
	
	
	
	public void updateZmianaCzasuInfo()
	{
		if(zInterfejs instanceof BezZmianyCzasu)
		{
			setZmianaCzasuInfo(Algorytm.opisBezZmianyCzasu);
		}
		else if(zInterfejs instanceof ZmianaCzasuUE)
		{
			setZmianaCzasuInfo(Algorytm.opisZmianyCzasuUE);

		}
		else if(zInterfejs instanceof ZmianaCzasuUS)
		{
			setZmianaCzasuInfo(Algorytm.opisZmianyCzasuUS);
		}
		
	}
	public void updateFormatGodzinyInfo()
	{
		if(gInterfejs instanceof gg24_mm)
		{
			setFormatGodzinyInfo(Algorytm.opisZmianyGodzinyGG24_MM);
		}
		else if(gInterfejs instanceof gg24_mm_ss)
		{
			setFormatGodzinyInfo(Algorytm.opisZmianyGodzinyGG24_MM_SS);

		}
		
	}
	public void updateFormatDatyInfo()
	{
		if(dInterfejs instanceof dd__AngielskaNazwaMies)
		{
			setFormatDatyInfo(Algorytm.opisZmianyDatyDD_AngielskaNazwaMies);
		}
		else if(dInterfejs instanceof dd__mm__AngielskiDzienTygodnia)
		{
			setFormatDatyInfo(Algorytm.opisZmianyDatyDD__MM__AngielskaDzienTygodnia);
		}
		else if(dInterfejs instanceof dd__mm__PolskiDzienTygodnia)
		{
			setFormatDatyInfo(Algorytm.opisZmianyDatyDD__MM__PolskiDzienTygodnia);
		}
		else if(dInterfejs instanceof dd__mm__rrrr)
		{
			setFormatDatyInfo(Algorytm.opisZmianyDatyDD__MM__RRRR);
		}
		else if(dInterfejs instanceof dd__PolskaNazwaMies)
		{
			setFormatDatyInfo(Algorytm.opisZmianyDatyDD__MM__RRRR);
		}
		
	}
	public String getFormatDatyInfo() {
		return FormatDatyInfo;
	}
	public void setFormatDatyInfo(String formatDatyInfo) {
		FormatDatyInfo = formatDatyInfo;
	}
	public String getFormatGodzinyInfo() {
		return FormatGodzinyInfo;
	}
	public void setFormatGodzinyInfo(String formatGodzinyInfo) {
		FormatGodzinyInfo = formatGodzinyInfo;
	}
	public String getZmianaCzasuInfo() {
		return ZmianaCzasuInfo;
	}
	public void setZmianaCzasuInfo(String zmianaCzasuInfo) {
		ZmianaCzasuInfo = zmianaCzasuInfo;
	}



	
}
