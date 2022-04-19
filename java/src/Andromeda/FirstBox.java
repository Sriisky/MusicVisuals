package Andromeda;

import ie.tudublin.*;

public class FirstBox extends Visual {
    AssignmentVisual myBoard;
    float angle = 0;

    FirstBox(AssignmentVisual viz) {
        this.myBoard = viz;
    }

    public void draw() {
        myBoard.background(0);
        myBoard.calculateAverageAmplitude();
        myBoard.stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        myBoard.strokeWeight(5);
        myBoard.noFill();
        myBoard.lights();
        myBoard.pushMatrix();
        //
        myBoard.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        myBoard.translate(0, 0, -200);

        myBoard.rotateX(angle);
        myBoard.rotateZ(angle);       
        float boxSize = 50 + (200 * getSmoothedAmplitude()); 
        myBoard.box(boxSize);   
        myBoard.popMatrix();
        angle += 0.01f;
    }
}
