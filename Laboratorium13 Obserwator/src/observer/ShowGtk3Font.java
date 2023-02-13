package observer;

import subject.Observable;
import subject.Theme;

public class ShowGtk3Font implements Observer, ShowFont{
	
	private String font;
	private int fontSize;
	private Observable ob=null;

	
	public ShowGtk3Font(Observable ob)
	{
		ob.registerObserver(this);
		this.ob=ob;
	}
	
	public void update()
	{
		font=((Theme)ob).getGtk3Font();
		fontSize=((Theme)ob).getGtk3FontSize();
		displayFont();
	}
	
	public void displayFont()
	{
		System.out.println("GTK3 font is: "+font+" "+fontSize);
	}
}
