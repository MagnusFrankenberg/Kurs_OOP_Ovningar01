package Sprint_4.Uppg_3_v2;

import javax.swing.*;
import java.awt.*;

public class ChattGUI extends JFrame {

    JPanel bottompanel = new JPanel();
    JTextArea textArea = new JTextArea();
    JTextField textField = new JTextField();
    JScrollPane scrollp = new JScrollPane(textArea);
    JButton button = new JButton("Koppla ner");

    Sender sender;

    public ChattGUI(String namn, Sender sender) {
        this.sender = sender;

        setSize(400, 400);
        setTitle(namn);
        bottompanel.setLayout(new BorderLayout());
        add(bottompanel);
        bottompanel.add(button, BorderLayout.NORTH);
        bottompanel.add(scrollp, BorderLayout.CENTER);
        bottompanel.add(textField, BorderLayout.SOUTH);

        button.addActionListener(sender);
        textField.addActionListener(sender);


        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void updateTextArea(String s){
        textArea.setText(textArea.getText()+s+"\n");
    }

}
