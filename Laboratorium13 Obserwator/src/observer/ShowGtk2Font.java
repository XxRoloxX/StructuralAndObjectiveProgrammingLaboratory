package observer;

import subject.Observable;
import subject.Theme;

public class ShowGtk2Font implements Observer, ShowFont{
	
	private String font;
	private int fontSize;
	private Observable ob=null;
	
	public ShowGtk2Font(Observable ob)
	{
		ob.registerObserver(this);
		this.ob=ob;
	}
	
	public void update()
	{
		font=((Theme)ob).getGtk2Font();
		fontSize=((Theme)ob).getGtk2FontSize();
		displayFont();
	}
	
	public void displayFont()
	{
		System.out.println("GTK2 font is: "+font+" "+fontSize);
	}
}
