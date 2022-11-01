package Sprint_3.Lektion_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextfieldTräning extends JFrame implements ActionListener {

    private JTextField svar = new JTextField(20);
    private JLabel hälsning = new JLabel();


    public TextfieldTräning() {
        setLayout(new FlowLayout());
        add(new JLabel("Vad heter du? ", JLabel.RIGHT));
        add(svar);
        add(hälsning);
        hälsning.setHorizontalAlignment(JLabel.RIGHT);
        svar.addActionListener(this);
        setLocationRelativeTo(null);
        setSize(350, 90);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String namn = svar.getText();
        hälsning.setText("Välkommen " + namn + "!");
    }


    public static void main(String[] args) {
        TextfieldTräning tf = new TextfieldTräning();
    }
}
