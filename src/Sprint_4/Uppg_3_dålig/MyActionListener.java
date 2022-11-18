package Sprint_4.Uppg_3_dålig;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyActionListener implements ActionListener {

    GUI gui;
    JButton button;
    JTextField textField;
    JTextArea textArea;
    MultiSender sender = new MultiSender();

    public MyActionListener(JButton button, JTextField textField, JTextArea textArea) throws IOException {
        this.button = button;
        this.textField = textField;
        this.textArea = textArea;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.exit(0);
        }
        if(e.getSource()==textField){
            textArea.setText(textArea.getText()+textField.getText()+"\n");
            try {
                sender.sendString(textField.getText() + "\n");
            }catch (IOException e1){
                System.out.println("Fel vid sändning");
            }
            textField.setText("");
        }
    }


}
