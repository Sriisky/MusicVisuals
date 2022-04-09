package Andromeda;

import ie.tudublin.*;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;


public class AssignmentVisual extends Visual
{ 
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;
    
    int mode = 0;
    float radius = 200;
    float smoothedBoxSize = 0;
    float rot = 0;
    float angle = 0;
    float off = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    Star[] stars = new Star[800];

    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        //fullScreen(P3D, SPAN);

        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
    }

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void setup()
    {
        colorMode(HSB);
        //noCursor();
        
        //setFrameSize(256);

        startMinim();
        loadAudio("andromeda.mp3");
        getAudioPlayer().play();
    }

    public void draw()
    {
        background(0);

        switch (mode) {

            //case 0 is a rotation cube
            case 0:
                background(0);
                calculateAverageAmplitude();
                stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
                strokeWeight(5);
                noFill();
                lights();
                pushMatrix();
                //
                camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
                translate(0, 0, -200);
                rotateX(angle);
                rotateZ(angle);       
                float boxSize = 50 + (200 * getSmoothedAmplitude()); 
                box(boxSize);   
                popMatrix();
                angle += 0.01f;
            break;

            //case 1 is a cube circling the centre of the screen
            case 1:
                calculateAverageAmplitude();
                try
                {
                    calculateFFT();
                }
                catch(VisualException e)
                {
                    e.printStackTrace();
                }
                calculateFrequencyBands();
                background(0);
                noFill();
                stroke(255);
                lights();
                stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
                camera(0, -500, 500, 0, 0, 0, 0, 1, 0);
                //translate(0, 0, -250);
        
                rot += getAmplitude() / 8.0f;
        
                rotateY(rot);
                float[] bands = getSmoothedBands();
                for(int i = 0 ; i < bands.length ; i++)
                {
                    float theta = map(i, 0, bands.length, 0, TWO_PI);
        
                    stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                    float x = sin(theta) * radius;
                    float z = cos(theta) * radius;
                    float h = bands[i];
                    pushMatrix();
                    translate(x, - h / 2 , z);
                    rotateY(theta);
                    box(50, h, 50);
                    popMatrix();
                }
            break;

            case 2:
                // i link the value of the speed variable to the mouse position.
                speed = map(mouseX, 0, width, 0, 50);

                background(0);
                // I shift the entire composition,
                // moving its center from the top left corner to the center of the canvas.
                translate(width/2, height/2);
                // I draw each star, running the "update" method to update its position and
                // the "show" method to show it on the canvas.
                for (int i = 0; i < stars.length; i++) {
                    stars[i].update();
                    stars[i].show();
                }
                
            break;
    }
}
}
