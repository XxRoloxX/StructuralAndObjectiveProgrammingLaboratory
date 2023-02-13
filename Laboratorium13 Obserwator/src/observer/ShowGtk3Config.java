package observer;

import subject.Observable;

public class ShowGtk3Config implements Observer, ShowConfig{
	
	private ShowGtk3Font font;
	private ShowGtk3Theme theme;
	private ShowGtk3IconTheme iconTheme;
	private Observable ob;
	
	public ShowGtk3Config(Observable ob)
	{
		theme = new ShowGtk3Theme(ob);
		iconTheme = new ShowGtk3IconTheme(ob);
		font = new ShowGtk3Font(ob);
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
		System.out.println("GTK3 config: ");
		theme.displayTheme();
		iconTheme.displayIconTheme();
		font.displayFont();
		System.out.println();
	}
}
