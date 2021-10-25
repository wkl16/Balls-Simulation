import java.awt.*;

public class Rocket {
    //declare instance variables
    Color color, red, orange, yellow;
    int size, xPosition, yPosition;

    Rocket () {
        //initialize the declared variables
        size = 14;
        xPosition = 112;
        yPosition = 680;
        red = Color.decode("#b62203");
        orange = Color.decode("#fc6400");
        yellow = Color.decode("#fac000");
    }

    void draw(Graphics g) {
        //define initial rocket position and rocket design with primitive shapes
        g.setColor(color);
        g.fillOval(xPosition-size/2,yPosition-size/2-size,size,size*2);
        g.fillRect(xPosition-size/2,yPosition-size/2, size, size);
        g.fillOval(xPosition-size/2,yPosition-size/2,size,size*2);
        int x[] = {xPosition, xPosition+size, xPosition-size};
        int y[] = {yPosition+size, yPosition+size*2, yPosition+size*2};
        int n = 3;
        Polygon p = new Polygon(x, y, n);
        g.fillPolygon(p);
        int u[] = {xPosition, xPosition+size/4, xPosition-size/4};
        int v[] = {yPosition-size*2, yPosition-size, yPosition-size};
        int w = 3;
        Polygon z = new Polygon(u, v, w);
        g.fillPolygon(z);
    }

    void flameS(Graphics g) {
        //define flame shape when moving backward
        g.setColor(red);
        g.fillOval(xPosition-size/4,yPosition+size*2,size/2,size*3/2);
    }
    void flameAD(Graphics g) {
        //define flame shape when moving left and right
        g.setColor(orange);
        g.fillOval(xPosition-size/2,yPosition+size*2,size,size*2);
        flameS(g);
    }
    void flameW(Graphics g) {
        //define flame shape when moving forward
        g.setColor(yellow);
        g.fillOval(xPosition-size/2,yPosition+size*2,size,size*3);
        flameAD(g);
    }
    void move(int dx, int dy) {
        //define rocket movement
        xPosition += dx;
        yPosition += dy;
    }
    void reappear (int windowWidth, int windowHeight) {
        //define rocket position when moving offscreen
        if (xPosition > windowWidth) {
            xPosition = 0;
        }
        if (xPosition < 0) {
            xPosition = windowWidth;
        }
        if (yPosition > windowHeight) {
            yPosition = 0;
        }
        if (yPosition < 0) {
            yPosition = windowHeight;
        }
    }
}
