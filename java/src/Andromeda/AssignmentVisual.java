package Andromeda;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.Minim;
import ie.tudublin.*;
import processing.core.PApplet;

public class AssignmentVisual extends Visual {
    public void settings() {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        // fullScreen(P3D, SPAN);
    }

    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();

        }

    }

    Star[] stars =  new Star[400];

    public void setup() {
        colorMode(HSB);
        // noCursor();

        setFrameSize(256);

        startMinim();
        loadAudio("andromeda.mp3");
        getAudioPlayer().play();
        // startListening();

        // Stars generation
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(this);
        }


        // Making Setup for Audio
        // Minim minim;
        // AudioInput ai;
        // AudioBuffer ab;
        // minim = new Minim(this);
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix;

    }

    public void draw() {

        background(0);
        noStroke();

        // for (int i = 0; i < ab.size(); i++) {
        //     float colour = map(ab.get(i), -1, 1, 0, 255);
        //     stroke(colour, 255, 255);
        // }

       

        // Assigning a value to wave so you can get the object to move with framecount
        // the radians is used to smooth it somehow because of maths

        float wave = sin(radians(frameCount));

        // The sphere in the middle rotation with random colours using stroke random function
        fill(0);
        lights();
        stroke(random(0, 255), 255 ,255);
        translate(400, 400, 0);
        rotateX(wave * 2);
        rotateY(wave * 2);
        sphere(100);
        
        // Stars Background
        pushMatrix();
        translate(width/2, height/2);
        for (int i = 0; i < stars.length; i++) {
            stars[i].update();
            stars[i].show();

        }
        popMatrix();









        // for (int i = 0; i < ab.size(); i++) {
        // float colour = map(ab.get(i), -1, 1, 0, 255);
        // //float colour = map(i, 0, ab.size(), 0, 255);
        // stroke(colour, 255, 255);
        // fill(colour, 255, 255);
        // //stroke(map(i, 0, getAudioBuffer().size(), 0, 255), 255, 255);
        // ellipse(width / 2, height / 2 + wave * 300, 100, 100);
        // }

        // heart shape idk what to do with it

        // smooth();
        // noStroke();
        // fill(255,255,255);
        // beginShape();
        // vertex(50, 15);
        // bezierVertex(50, -5, 90, 5, 50, 40);
        // vertex(50, 15);
        // bezierVertex(50, -5, 10, 5, 50, 40);
        // endShape();
    }
}