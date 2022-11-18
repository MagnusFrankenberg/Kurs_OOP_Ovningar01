package Sprint_4.Uppg_3_dålig;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI extends JFrame {

    JPanel bottompanel = new JPanel();
    JTextArea textArea = new JTextArea();
    JTextField textField = new JTextField();
    JScrollPane scrollp = new JScrollPane(textArea);
    JButton button = new JButton("Koppla ner");

    public GUI() throws IOException {

        setSize(400,400);
        bottompanel.setLayout(new BorderLayout());
        add(bottompanel);
        bottompanel.add(button,BorderLayout.NORTH);
        bottompanel.add(scrollp,BorderLayout.CENTER);
        bottompanel.add(textField,BorderLayout.SOUTH);

        button.addActionListener(new MyActionListener(button,textField, textArea));
        textField.addActionListener(new MyActionListener(button,textField, textArea));



        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
