package Sprint_3.Uppgift_1c;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bildvisare extends JFrame implements ActionListener {

    ImagesManager manager = new ImagesManager();

    JPanel p1 = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();

    ImageIcon im1 = new ImageIcon(manager.bilder.get(0).toString());

    JLabel l1 = new JLabel(im1);
    JButton b1 = new JButton("Växla bild");

    public static int elementnumber = 1;

    public ImageIcon imageChanger2() {
        String sPath = manager.bilder.get(elementnumber).toString();
        ImageIcon imx = new ImageIcon(sPath);
        elementnumber = (elementnumber+1)%(manager.bilder.size());
        return imx;
    }
    public Bildvisare() {


        setLayout(new FlowLayout());
        add(p1);
        p1.setLayout(new BorderLayout());
        p1.add(northPanel,BorderLayout.NORTH);
        p1.add(southPanel,BorderLayout.SOUTH);
        southPanel.add(l1);
        northPanel.add(b1);
        b1.addActionListener(this);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        l1.setIcon(imageChanger2());
    }

    public static void main(String[] args) {

        Bildvisare bv = new Bildvisare();
    }
}
