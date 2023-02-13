package Serializacja;
import DataObsluga.DataObsluga;
import panstwa.Data;
import java.io.*;
import java.util.*;

public class Serializacja{
		
	public static void SerializacjaDoPliku(Data[] ob, String nazwaPliku)
	{
		try(ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(new File(nazwaPliku))))
		{
			OOS.writeObject(ob);
			
		}catch(FileNotFoundException e)
		{
			System.out.println("Nie znaleziono pliku");
		}
		catch(IOException e)
		{
			System.out.println("Problem z zapisem do pliku");
		}
	}
	public static Data[] OdczytZPliku(String nazwaPliku)
	{
		Data[] wynik=null;

		try(ObjectInputStream OOS = new ObjectInputStream(new FileInputStream(nazwaPliku)))
		{	
	
			wynik = ((Data[])OOS.readObject());
			
		}catch(FileNotFoundException e)
		{
			System.out.println("Nie znaleziono pliku");
		}
		catch(IOException e)
		{
			System.out.println("Problem z odczytem z pliku");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Nie znaleziono klasy");
		}
		
		return wynik;
	}
	
	

}
