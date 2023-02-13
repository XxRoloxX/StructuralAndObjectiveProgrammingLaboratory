package observer;

import subject.Observable;
import subject.Theme;

public class ShowGtk2IconTheme implements Observer, ShowIconTheme {
	
	private String iconTheme;
	private Observable ob=null;

	
	public ShowGtk2IconTheme(Observable ob)
	{
		ob.registerObserver(this);
		this.ob=ob;
	}
	
	public void update()
	{
		iconTheme=((Theme)ob).getGtk2IconTheme();
		displayIconTheme();
	}
	
	public void displayIconTheme()
	{
		System.out.println("GTK2 icon-theme is: "+iconTheme);
	}
}
