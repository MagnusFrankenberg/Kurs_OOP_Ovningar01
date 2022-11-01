package Sprint_3.Lektion_1;

import javax.swing.*;
import java.awt.*;


public class SwingTest extends JFrame {

    JLabel l1 = new JLabel("Hej Magnus");
    JButton b1 = new JButton("Tryck här");
    JLabel l2 = new JLabel("Hej Sixten");
    JButton b2 = new JButton("Tryck inte här");
    JLabel l3 = new JLabel("Hej Sigge");
    JButton b3 = new JButton("Tryck kanske här");
    JPanel p1 = new JPanel();

    SwingTest() {
        p1.setLayout(new GridLayout(3, 2));
        add(p1);
        p1.add(l1);
        p1.add(b1);
        p1.add(l2);
        p1.add(b2);
        p1.add(l3);
        p1.add(b3);
        pack();
        // setSize(930,500);
        setLocation(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l2.setForeground(Color.red);
        p1.setBackground(Color.LIGHT_GRAY);

        /*
        setSize(930,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        */

    }

    public static void main(String[] args) {
        SwingTest st = new SwingTest();
    }

}
