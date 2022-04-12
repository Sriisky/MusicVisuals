package ie.tudublin;

import Andromeda.*;

public class Main
{	

	public void startUI1()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new AssignmentVisual());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI1();			
	}
}