package observer;
import subject.Observable;

public class ShowGtk2Config implements Observer, ShowConfig{
	
	private ShowGtk2Font font;
	private ShowGtk2Theme theme;
	private ShowGtk2IconTheme iconTheme;
	private Observable ob;
	
	public ShowGtk2Config(Observable ob)
	{
		theme = new ShowGtk2Theme(ob);
		iconTheme = new ShowGtk2IconTheme(ob);
		font = new ShowGtk2Font(ob);
		this.ob = ob;
	}
	
	public void update()
	{
		theme.update();
		iconTheme.update();
		font.update();
	}
	public void displayConfig()
	{
		System.out.println("GTK2 config: ");
		theme.displayTheme();
		iconTheme.displayIconTheme();
		font.displayFont();
		System.out.println();
	}

}
