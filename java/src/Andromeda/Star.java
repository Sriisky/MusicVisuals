package Andromeda;

public class Star extends AssignmentVisual {
    AssignmentVisual floor;
    float x;
    float y;
    float z;

    // Initialise an instance of a star when it is created in AssignmentVisual
    Star(AssignmentVisual star) {
        this.floor = star;
        x = random(-width, width);
        y = random(-height, height);
        z = random(width);
    }

    void update() {
        z = (float) (z - 0.25);
        if (z < 1) {
            z = width;
            x = random(-width, width);
            y = random(-height, height);
        }
    }

    void show() {
        float sx = map(x / z, 0, 1, 0, width);
        float sy = map(y / z, 0, 1, 0, width);
        // floor.fill(random(0,255),255,255);
        floor.fill(255);
        floor.noStroke();

        float r = map(z, 0, width, 16, 0);
        floor.ellipse(sx, sy, r, r);
        // floor.box(sx,sy,r);

    }

}
