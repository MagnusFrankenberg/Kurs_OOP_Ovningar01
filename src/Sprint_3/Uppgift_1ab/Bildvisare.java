package Sprint_3.Uppgift_1ab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bildvisare extends JFrame implements ActionListener {

    String bild1 = "/Users/magnusfrankenberg/Desktop/BilderTillJavaTräning/bulldog.jpg";
    String bild2 = "/Users/magnusfrankenberg/Desktop/BilderTillJavaTräning/cat.jpg";

    JPanel p1 = new JPanel();
    ImageIcon im1 = new ImageIcon(bild1);
    ImageIcon im2 = new ImageIcon(bild2);
    JLabel l1 = new JLabel(im1);
    JButton b1 = new JButton("Växla bild");


    public Bildvisare() {


        setLayout(new FlowLayout());
        add(p1);
        p1.setLayout(new FlowLayout());
        p1.add(l1);
        p1.add(b1);
        b1.addActionListener(this);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(l1.getIcon().equals(im1)) {
            l1.setIcon(im2);
        }else{
            l1.setIcon(im1);
            }
        }

    public static void main(String[] args) {
        Bildvisare bv = new Bildvisare();
    }


}
