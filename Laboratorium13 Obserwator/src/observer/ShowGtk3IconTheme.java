package observer;

import subject.Observable;
import subject.Theme;

public class ShowGtk3IconTheme implements Observer, ShowIconTheme{
	
	private String iconTheme;
	private Observable ob=null;

	
	public ShowGtk3IconTheme(Observable ob)
	{
		ob.registerObserver(this);
		this.ob=ob;
	}
	
	public void update()
	{
		iconTheme=((Theme)ob).getGtk3IconTheme();
		displayIconTheme();
	}
	
	public void displayIconTheme()
	{
		System.out.println("GTK3 icon-theme is: "+iconTheme);
	}
}
