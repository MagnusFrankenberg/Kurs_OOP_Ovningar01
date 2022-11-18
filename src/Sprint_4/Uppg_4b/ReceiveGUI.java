package Sprint_4.Uppg_4b;

import javax.swing.*;

import java.awt.*;



public class ReceiveGUI extends JFrame {


    JPanel panel = new JPanel();
    JTextArea textArea = new JTextArea();
    JScrollPane scrollp = new JScrollPane(textArea);

    public ReceiveGUI(){

        setSize(250,600);
        panel.setLayout(new BorderLayout());
        add(panel);
        panel.add(scrollp, BorderLayout.CENTER);

        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void updateTextArea(String s){

        textArea.setText(textArea.getText()+s+"\n");
    }

}
