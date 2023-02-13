package observer;

import subject.*;

public class ShowGtk2Theme implements Observer, ShowTheme{
	
	private String theme;
	private Observable ob=null;

	
	public ShowGtk2Theme(Observable ob)
	{
		ob.registerObserver(this);
		this.ob=ob;
	}
	
	public void update()
	{
		theme=((Theme)ob).getGtk2Theme();
		displayTheme();
	}
	
	public void displayTheme()
	{
		System.out.println("GTK2 theme is: "+theme);
	}

}
