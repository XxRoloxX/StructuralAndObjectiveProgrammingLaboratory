package subject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import gtk.GtkTemplate;
import observer.Observer;

public class Theme implements Observable {
	
	private ArrayList<Observer>observers;
	
	private String gtk3Theme;
	private String gtk3IconTheme;
	private String gtk3Font;
	private int gtk3FontSize;
	
	private String gtk2Theme;
	private String gtk2IconTheme;
	private String gtk2Font;
	private int gtk2FontSize;
	
	public Theme()
	{
		observers = new ArrayList<>();
	}

	public void configChanged()
	{
		notifyObservers();
	}

	public void registerObserver(Observer ob)
	{
		observers.add(ob);
	}
	public void removeObserver(Observer ob)
	{
		observers.remove(ob);
	}
	public void notifyObservers()
	{
		for(int i=0;i<observers.size();i++)
		{
			observers.get(i).update();
		}
	}
	public void readCurrentGtkConfig()
	{
		readCurrentGtk3Config();
		readCurrentGtk2Config();
		configChanged();
	}
	
	public void readCurrentGtk3Config()
	{
		try(BufferedReader breader = new BufferedReader(new FileReader(GtkTemplate.gtk3Path)))
		{			
			String line;
			String[] regexTable;
			String[] configTable = new String[3];
			int iterator =0;
			breader.readLine();
			while((line=breader.readLine())!=null && line.length()>0)
			{
				line.trim();
				regexTable=line.split(" = ");
				configTable[iterator]=regexTable[1];
				iterator++;
			}
			
			gtk3IconTheme=configTable[0];
			gtk3Theme=configTable[1];
			
			regexTable = configTable[2].split("\s+");
			gtk3Font="";
			
			for(int i=0;i<regexTable.length -1;i++)
			{
				gtk3Font+=regexTable[i]+" ";
			}
			
			gtk3FontSize = Integer.parseInt(regexTable[regexTable.length-1]);			
			
		}catch(FileNotFoundException e)
		{
			System.out.println("Nie znaleziono pliku !");
		}
		catch(IOException e)
		{
			System.out.println("Błąd z dostępem do pliku !");
		}
	}
	public void readCurrentGtk2Config()
	{
		try(BufferedReader breader = new BufferedReader(new FileReader(GtkTemplate.gtk2Path)))
		{			
			String line;
			String[] regexTable;
			String[] configTable = new String[3];
			int iterator =0;
			while((line=breader.readLine())!=null && line.length()>0)
			{
				line.trim();
				regexTable=line.split(" = ");
				configTable[iterator]=regexTable[1];
				iterator++;
			}
			
			gtk2IconTheme=configTable[0];
			gtk2Theme=configTable[1];
			
			regexTable = configTable[2].split("\s+");
			gtk2Font="";
			
			for(int i=0;i<regexTable.length -1;i++)
			{
				gtk2Font+=regexTable[i]+" ";
			}
			
			gtk2FontSize = Integer.parseInt(regexTable[regexTable.length-1]);
			
			
		}catch(FileNotFoundException e)
		{
			System.out.println("Nie znaleziono pliku !");
		}
		catch(IOException e)
		{
			System.out.println("Błąd z dostępem do pliku !");
		}
	}

	public String getGtk3Theme() {
		return gtk3Theme;
	}

	public void setGtk3Theme(String gtk3Theme) {
		this.gtk3Theme = gtk3Theme;
	}

	public String getGtk3IconTheme() {
		return gtk3IconTheme;
	}

	public void setGtk3IconTheme(String gtk3IconTheme) {
		this.gtk3IconTheme = gtk3IconTheme;
	}

	public String getGtk3Font() {
		return gtk3Font;
	}

	public void setGtk3Font(String gtk3Font) {
		this.gtk3Font = gtk3Font;
	}

	public int getGtk3FontSize() {
		return gtk3FontSize;
	}

	public void setGtk3FontSize(int gtk3FontSize) {
		this.gtk3FontSize = gtk3FontSize;
	}

	public String getGtk2Theme() {
		return gtk2Theme;
	}

	public void setGtk2Theme(String gtk2Theme) {
		this.gtk2Theme = gtk2Theme;
	}

	public String getGtk2IconTheme() {
		return gtk2IconTheme;
	}

	public void setGtk2IconTheme(String gtk2IconTheme) {
		this.gtk2IconTheme = gtk2IconTheme;
	}

	public String getGtk2Font() {
		return gtk2Font;
	}

	public void setGtk2Font(String gtk2Font) {
		this.gtk2Font = gtk2Font;
	}

	public int getGtk2FontSize() {
		return gtk2FontSize;
	}

	public void setGtk2FontSize(int gtk2FontSize) {
		this.gtk2FontSize = gtk2FontSize;
	}
	
		
	
}
