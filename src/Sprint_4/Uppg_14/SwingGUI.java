package Sprint_4.Uppg_14;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.Properties;

public class SwingGUI extends JFrame {

    JPanel panel = new JPanel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JButton button = new JButton("Knapp");


    public SwingGUI(){

        Properties p = new LoadProperties().prop;

        System.out.println(p.getProperty("framesizeWidth","400"));

        int framesizeW = Integer.parseInt(p.getProperty("framesizeWidth", "400"));
        int framesizeL = Integer.parseInt(p.getProperty("framesizeLength","100"));
        String fTitle = p.getProperty("frameTitle", "Reservtitel");
        String mess = p.getProperty("message","Reservmeddelande");

        setSize(framesizeW,framesizeL);
        setTitle(fTitle);
        add(panel);
        panel.setLayout(new BorderLayout());

        panel.add(label1, BorderLayout.NORTH);
        //panel.add(label2, BorderLayout.NORTH);
        panel.add(label3, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        label1.setText(mess);
        label2.setText(mess);
        label3.setText(mess);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        SwingGUI sg = new SwingGUI();
    }

}
