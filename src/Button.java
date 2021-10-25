import javax.swing.*;
import java.awt.*;

public class Button {
    //declare instance variables
    Color color;
    int yPosition, xPosition, size;

    Button () {
        //initialize the declared variables
        size = 25;
        xPosition = 100;
        yPosition = 745;
    }

    void draw (Graphics g) {
        //define button shapes and position
        g.setColor(color);
        g.fillRect(xPosition-size*3/2,yPosition, size, size);
        g.fillRect(xPosition,yPosition, size, size);
        g.fillRect(xPosition+size*3/2,yPosition, size, size);
        g.fillRect(xPosition,yPosition-size*3/2, size, size);
    }
}
