import javax.swing.*;
import java.awt.*;

public class Star {
    //declare instance variables
    Color color;
    int size, xPosition, yPosition;
    int xSpeed, ySpeed;

    Star(int winddowWidth, int windowHeight) {
        //initialize the declared variables
        int minSize = 6;
        int maxSize = 24;
        size = minSize + (int) (Math.random() * (maxSize - minSize + 1));
        xPosition = size/2 + (int) (Math.random() * (winddowWidth - size + 1));
        yPosition = size/2 + (int) (Math.random() * (windowHeight - size + 1));
        xSpeed = 1 + (int) (Math.random()*6);
        ySpeed = 1 + (int) (Math.random()*6);
    }

    void move() {
        //define star movement
        xPosition += xSpeed;
        yPosition += ySpeed;
    }

    void draw (Graphics g) {
        //define star shape and position
        g.setColor(color);
        g.fillOval(xPosition,yPosition,size,size);
    }

    void bounce (int windowWidth, int windowHeight) {
        //define star bounce physics when reach panel boundaries
        if (xPosition+size/2 > windowWidth || xPosition-size/2 < 0) {
            xSpeed = -xSpeed;
        }
        if (yPosition+size/2 > windowHeight || yPosition-size/2 < 0) {
            ySpeed = -ySpeed;
        }
    }
}