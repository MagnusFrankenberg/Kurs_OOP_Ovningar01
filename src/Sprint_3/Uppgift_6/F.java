package Sprint_3.Uppgift_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class F extends JFrame{


    JPanel bottomPanel = new JPanel();
    JTextField tf = new JTextField("Första");
    JButton jb1 = new JButton("Knapp 1");
    JButton jb2 = new JButton("Knapp 2");


    WindowAdapter fönsterlyssnare = new WindowAdapter() {
        @Override
        public void windowActivated(WindowEvent e) {
            tf.requestFocus();
        }
    };

    FocusListener focusLyss = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            tf.setBackground(Color.blue);
        }

        @Override
        public void focusLost(FocusEvent e) {
            tf.setBackground(Color.white);
        }
    };




    public  F(){
        bottomPanel.setLayout(new GridLayout(3,1));
        add(bottomPanel);
        bottomPanel.add(tf);
        bottomPanel.add(jb1);
        bottomPanel.add(jb2);
        tf.addFocusListener(focusLyss);
        tf.setBackground(Color.BLUE);
        addWindowListener(fönsterlyssnare);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


    public static void main(String[] args) {
        F f = new F();

    }
}
