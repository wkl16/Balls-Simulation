/*****************************************
 * Assignment 4
 * Name: Kai Li "Leo" Wang
 * E-mail:  lwang16@unm.edu
 * Course:      CS 152 - Section 001
 * Submitted:    10/07/2021
 *
 * A program that creates a panel that emulate
 * a comet-filled outer space. Press WASD and E
 * to interact with the rocket, and press Q to
 * interact with the stars and the background.
 ***********************************************/
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class MyPanel extends JPanel implements KeyListener {
    //declare instance variables
    Color background;
    int width, height, dx, dy;
    int numofStars, greyscale;
    char keyTyped, keyReleased;
    Star[] stars;
    Rocket rocket;
    Button button;

    MyPanel() {
        //initialize declared variables
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of stars: ");
        numofStars = sc.nextInt();
        width = 800;
        height = 800;
        /* numofStars = 20; */
        keyTyped = ' ';
        keyReleased = ' ';
        background = Color.black;
        dx = 4;
        dy = 4;
        stars = new Star[numofStars];
        //generates stars in random location on screen
        for (int i = 0; i < numofStars; i++) {
            stars[i] = new Star(width, height);
        }
        //create new instances of Classes for accessing their methods
        rocket = new Rocket();
        button = new Button();
        //define panel and set focus
        setLayout(null);
        Dimension dim = new Dimension(width, height);
        setPreferredSize(dim);
        setVisible(true);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        requestFocusInWindow();
    }

    public static void main(String[] args) {
        MyPanel panel = new MyPanel();
        MyFrame frame = new MyFrame(panel);
        panel.animate(60);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(background);
        //assign and paint star methods to every star
        for (int i = 0; i < numofStars; i++) {
            stars[i].draw(g);
            stars[i].move();
            stars[i].bounce(width, height);
        }
        //assign and paint rocket and button methods
        rocket.reappear(width, height);
        rocket.draw(g);
        button.draw(g);

        //define and paint strings on panel
        int fontSize = 25;
        Font f = new Font("Courier", Font.BOLD, fontSize);
        g.setFont(f);
        String s = Character.toString(keyTyped);
        g.drawString("Q", 69, 732);
        g.drawString("E", 143, 732);
        int fontSize1 = 15;
        Font f1 = new Font("Courier", Font.BOLD, fontSize1);
        g.setFont(f1);
        g.setColor(Color.white);
        g.drawString("Press Q to change BG and Ball", 280, 770);
        g.drawString("Press E to change Rocket and Button", 280, 790);

        //assign wasd keys to corresponding movements and flame sizes
        if (keyTyped == 'w') {
            rocket.move(0,-dy);
            rocket.flameW(g);
        }
        if (keyTyped == 'a') {
            rocket.move(-dx,0);
            rocket.flameAD(g);
        }
        if (keyTyped == 's') {
            rocket.move(0,dy);
            rocket.flameS(g);
        }
        if (keyTyped == 'd') {
            rocket.move(dx,0);
            rocket.flameAD(g);
        }
        if (keyReleased == 'w') {
            rocket.move(0,0);
        }
    }

    void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println("I couldn't sleep!");
        }
    }

    void animate(int framerate) {
        int delay = 1000 / framerate;
        while (true) {
            repaint();
            delay(delay);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        keyTyped = e.getKeyChar();
        //assign 'q' key to change star and background color
        if (keyTyped == 'q') {
            greyscale = (int) (Math.random()*256);
            background = new Color(greyscale, greyscale, greyscale);
            int bColor = Math.abs(greyscale-255);
            for (int i = 0; i < numofStars; i++) {
                stars[i].color = new Color(bColor, bColor, bColor);
            }
        }
        //assign 'e' key to change rocket and button color
        if (keyTyped == 'e') {
            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);
            rocket.color = new Color(red, green, blue);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        keyReleased = e.getKeyChar();
    }
}