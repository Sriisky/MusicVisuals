package Andromeda;

public class Star extends AssignmentVisual {
    AssignmentVisual star;
    float x;
    float y;
    float z;

    Star(AssignmentVisual star) {
        x = random(-width, width);
        y = random(-height, height);
        z = random(width);
    }

    void update() {
        z = z - 5;
        if (z < 1) {
            z = width;
            x = random(-width, width);
            y = random(-height, height);
        }
    }

    void show() {
        float sx = map(x / z, 0, 1, 0, width);
        float sy = map(y / z, 0, 1, 0, width);
        fill(255);
        noStroke();

        float r = map(z, 0, width, 16, 0);
        ellipse(sx, sy, r, r);

    }

}
