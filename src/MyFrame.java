import javax.swing.*;
import java.awt.*;

public class MyFrame {
    JFrame frame;
    JPanel panel;

    MyFrame (JPanel p) {
        panel = p;
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
