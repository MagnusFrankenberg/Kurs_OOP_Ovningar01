package Sprint_4.Uppg_4b;

import javax.swing.*;
import java.awt.*;

public class SenderGUI extends JFrame{

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextField textField = new JTextField(5);
    JButton button = new JButton("Rapportera");

    Sender sender;

    public SenderGUI(String city, Sender sender){
        this.sender= sender;
        frame.setTitle(city);
        frame.setSize(400,80);
        panel.setLayout(new FlowLayout());
        frame.add(panel);
        panel.add(textField);
        panel.add(button);
        button.addActionListener(sender);


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
