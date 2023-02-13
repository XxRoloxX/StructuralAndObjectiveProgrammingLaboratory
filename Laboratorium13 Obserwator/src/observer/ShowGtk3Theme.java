package observer;

import subject.Observable;
import subject.Theme;

public class ShowGtk3Theme implements Observer, ShowTheme {
	
	private String theme;
	private Observable ob=null;

	
	public ShowGtk3Theme(Observable ob)
	{
		ob.registerObserver(this);
		this.ob=ob;
	}
	
	public void update()
	{
		theme=((Theme)ob).getGtk3Theme();
		displayTheme();
	}
	
	public void displayTheme()
	{
		System.out.println("GTK3 theme is: "+theme);
	}
	
	
}
