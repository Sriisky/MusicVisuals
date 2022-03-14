package ie.tudublin;

import Andromeda.AssignmentVisual;
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main
{	

	public void startUI0()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}

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