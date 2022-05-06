package Andromeda;

import ie.tudublin.*;
import processing.core.PApplet;

public class AssignmentVisual extends Visual {
    public void settings() {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        // fullScreen(P3D, SPAN);
    }

    int mode = 1;
    float a; // Angle of rotation
    float offset = (float) (PI / 24.0); // Angle offset between boxes
    int num = 12; // Number of boxes
    float wave = sin(radians(frameCount));

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

    Star[] stars = new Star[400];
    float smothedAmplitude;
    float smoothedBoxSize;

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
        // float colour = map(ab.get(i), -1, 1, 0, 255);
        // stroke(colour, 255, 255);
        // }

        switch (mode) {
            case 1: {

                // Assigning a value to wave so you can get the object to move with framecount
                // the radians is used to smooth it somehow because of maths

                float wave = sin(radians(frameCount));
                calculateAverageAmplitude();
                float daddy = 50 + (200 * getSmoothedAmplitude());

                // The sphere in the middle rotation with random colours using stroke random
                // function
                pushMatrix();
                // fill(random(0,255), 255 ,255);
                fill(0);
                lights();
                strokeWeight(1);
                stroke(random(0, 255), 255, 255);
                // stroke(255);
                translate(400, 400, 0);
                rotateX(wave);
                rotateY(wave);
                sphere(100);
                popMatrix();

                pushMatrix();
                lights();
                stroke(random(0, 255), 255, 255);
                fill(0);
                translate(200, 200, wave * 200);
                rotate(wave);
                box(daddy);

                popMatrix();

                pushMatrix();
                lights();
                stroke(random(0, 255), 255, 255);
                fill(0);
                translate(200, 600, wave * 200);
                rotateX(wave);
                rotateY(wave);
                box(daddy);
                popMatrix();

                pushMatrix();
                lights();
                stroke(random(0, 255), 255, 255);
                fill(0);
                translate(600, 200, wave * 200);
                rotateX(wave);
                rotateY(wave);
                box(daddy);
                popMatrix();

                pushMatrix();
                lights();
                stroke(random(0, 255), 255, 255);
                fill(0);
                translate(600, 600, wave * 200);
                rotate(wave);
                box(daddy);
                popMatrix();

                // pushMatrix();
                // stroke(100);
                // fill(255);
                // beginShape(TRIANGLES);
                // vertex(100, -100, 100);
                // vertex(-100, 100, 100);
                // vertex(100, 100, 100);
                // vertex(100, -100, 100);
                // endShape();
                // popMatrix();

                // Stars Background
                translate(width / 2, height / 2);
                for (int i = 0; i < stars.length; i++) {
                    stars[i].update();
                    stars[i].show();

                }

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

                break;
            case 2: {
                background(0);
                calculateAverageAmplitude();
                float wave = sin(radians(frameCount));
                float daddy = 10 + (200 * getSmoothedAmplitude());
                stroke(random(0, 255), 255, 255);

                // cubes

                pushMatrix();
                lights();
                stroke(random(0, 255), 255, 255);
                fill(0);
                translate(400, 200, wave * 200);
                rotateX(wave);
                rotateY(wave);
                box(daddy);
                popMatrix();

                pushMatrix();
                lights();
                strokeWeight(2);
                stroke(random(0, 255), 255, 255);
                fill(0);
                translate(400, 600, wave * 200);
                rotate(wave);
                box(daddy);
                popMatrix();

                // spheres
                pushMatrix();
                strokeWeight(1);
                stroke(random(0, 255), 255, 255);
                fill(0);
                rotateX(wave);
                translate(200, 400, wave * 200);
                sphere(daddy / 2);
                popMatrix();

                pushMatrix();
                strokeWeight(1);
                stroke(random(0, 255), 255, 255);
                rotateX(wave);
                fill(0);
                translate(600, 400, wave * 200);
                sphere(daddy / 2);
                popMatrix();

                // LINES
                // stroke(180, 255, 255);
                strokeWeight(2);
                line(0 + daddy * 3, 0 + daddy * 3, width / 2 - daddy, height / 2 - daddy);
                line(0 + daddy * 3, 800 - daddy * 3, width / 2 - daddy, height / 2 + daddy);
                line(800 - daddy * 3, 800 - daddy * 3, width / 2 + daddy, height / 2 + daddy);
                line(800 - daddy * 3, 0 + daddy * 3, width / 2 + daddy, height / 2 - daddy);

                // STAR
                pushMatrix();
                fill(0);
                // stroke(30, 255, 255);
                beginShape();
                vertex(width / 2, height / 2 + daddy);
                vertex(width / 2 + 10 + daddy, height / 2 + 10 + daddy);
                vertex(width / 2 + daddy, height / 2);
                vertex(width / 2 + 10 + daddy, height / 2 - 10 - daddy);
                vertex(width / 2, height / 2 - daddy);
                vertex(width / 2 - 10 - daddy, height / 2 - 10 - daddy);
                vertex(width / 2 - daddy, height / 2);
                vertex(width / 2 - 10 - daddy, height / 2 + 10 + daddy);
                vertex(width / 2, height / 2 + daddy);
                endShape();
                popMatrix();

                pushMatrix();
                // stroke(220, 255, 255);
                beginShape();
                vertex(width / 2, height / 2 + daddy);
                vertex(width / 2 + 10, height / 2 + 10);
                vertex(width / 2 + daddy, height / 2);
                vertex(width / 2 + 10, height / 2 - 10);
                vertex(width / 2, height / 2 - daddy);
                vertex(width / 2 - 10, height / 2 - 10);
                vertex(width / 2 - daddy, height / 2);
                vertex(width / 2 - 10, height / 2 + 10);
                vertex(width / 2, height / 2 + daddy);
                endShape();
                popMatrix();

                // triangle
                pushMatrix();
                // stroke(120, 255, 255);
                noFill();
                beginShape();
                vertex(width / 2, height / 2 + daddy * 2);
                vertex(width / 2 + daddy * 2, height / 2);
                vertex(width / 2, height / 2 - daddy * 2);
                vertex(width / 2 - daddy * 2, height / 2);
                vertex(width / 2, height / 2 + daddy * 2);
                endShape();
                popMatrix();

                // cricle
                pushMatrix();
                // stroke(random(0, 255), 255, 255);
                fill(0);
                circle(width / 2, height / 2, daddy / 4);
                circle(width / 2 + 50 + daddy, height / 2 - 10 + daddy, daddy - 10);
                circle(width / 2 - 50 - daddy, height / 2 - 10 + daddy, daddy - 10);
                popMatrix();

            }
                break;

            case 3: {
                calculateAverageAmplitude();
                float daddy = 10 + (200 * getSmoothedAmplitude());
                background(0);
                lights();

                translate(width / 2, height / 2);

                for (int i = 0; i < num; i++) {
                    fill(0);
                    pushMatrix();
                    stroke(random(0, 255), 255, 255);
                    // fill(gray);
                    rotateY(a + offset * i);
                    rotateX(a / 2 + offset * i);
                    box(daddy*5);
                    popMatrix();
                }

                a += 0.01;

            }
                break;
        }

    }
}