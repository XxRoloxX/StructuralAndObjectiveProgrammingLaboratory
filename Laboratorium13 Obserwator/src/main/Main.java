package main;
import gtk.Gtk;
import subject.Theme;
import observer.ShowGtk2Config;
import observer.ShowGtk3Config;
public class Main {

	public static void main(String[] args) {
		Theme theme = new Theme();
		
		ShowGtk2Config gtk2 = new ShowGtk2Config(theme);
		ShowGtk3Config gtk3 = new ShowGtk3Config(theme);
		
		theme.readCurrentGtkConfig();
		Gtk.changeGtkConfig("Papirus", "Arc-Dark", "DejaVu Sans" ,11);
		
		System.out.println("----CONFIG CHANGED----");
		theme.readCurrentGtkConfig();
		




	}

}
