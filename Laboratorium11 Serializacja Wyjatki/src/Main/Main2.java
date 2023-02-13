package Main;
import DataObsluga.DataObsluga;

public class Main2 {

	public static void main(String[] args) {
		DataObsluga ob = new DataObsluga();
		ob.wyborDaty();
		ob.ZapisDoPliku("test1.txt");
		
		DataObsluga ob2 = new DataObsluga();
		ob2.OdczytZPliku("test1.txt");
		ob2.wyswietlanieTablicy();

	}

}
