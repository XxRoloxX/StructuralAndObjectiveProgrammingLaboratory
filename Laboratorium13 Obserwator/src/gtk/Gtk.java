package gtk;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Gtk {
	
	public static void changeGtkConfig(String iconTheme, String theme, String font,int fontSize)
	{
		changeGtk3Config(iconTheme,theme,font,fontSize);
		changeGtk2Config(iconTheme,theme,font,fontSize);
	}
	
	public static void changeGtk2Config(String iconTheme, String theme, String font, int fontSize)
	{
		try(BufferedWriter bwriter = new BufferedWriter(new FileWriter(GtkTemplate.gtk2Path)))
		{
			bwriter.write(GtkTemplate.gtkIconTheme + iconTheme+"\n");
			bwriter.write(GtkTemplate.gtkTheme + theme+"\n");
			bwriter.write(GtkTemplate.gtkFontName + font +" "+fontSize);
			
			bwriter.flush();			
			
		}catch(FileNotFoundException e)
		{
			System.out.println("Nie znaleziono pliku !");
		}
		catch(IOException e)
		{
			System.out.println("Błąd z dostępem do pliku !");
		}
		
	}
	
	public static void changeGtk3Config(String iconTheme, String theme, String font, int fontSize)
	{
		try(BufferedWriter bwriter = new BufferedWriter(new FileWriter(GtkTemplate.gtk3Path)))
		{
			bwriter.write(GtkTemplate.gtk3Header);
			bwriter.write(GtkTemplate.gtkIconTheme + iconTheme+"\n");
			bwriter.write(GtkTemplate.gtkTheme + theme+"\n");
			bwriter.write(GtkTemplate.gtkFontName + font +" "+fontSize);
			
			bwriter.flush();			
			
		}catch(FileNotFoundException e)
		{
			System.out.println("Nie znaleziono pliku !");
		}
		catch(IOException e)
		{
			System.out.println("Błąd z dostępem do pliku !");
		}
		
	}
}
