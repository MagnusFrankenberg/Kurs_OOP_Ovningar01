package Sprint_3.Uppgift_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mus extends JFrame {


    JPanel bottomPanel = new JPanel();
    JLabel jl = new JLabel("Var är musen?");
    JButton jb = new JButton("en knapp");

    MouseListener muslyssnare = new MouseAdapter() {

        @Override
        public void mouseEntered(MouseEvent e) {
            jb.setForeground(Color.RED);
            jb.revalidate();
            jl.setText("Här är musen");
        }
        @Override
        public void mouseExited(MouseEvent e) {
            jb.setForeground(Color.black);
            jb.revalidate();
            jl.setText("Var är musen?");
        }
    };


    public Mus(){
        add(bottomPanel);
        bottomPanel.add(jl);
        bottomPanel.add(jb);
        jb.addMouseListener(muslyssnare);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


    }


    public static void main(String[] args) {
        Mus m = new Mus();

    }


}
