package Sprint_4.Uppg_12;


import javax.swing.*;
import java.awt.*;

    public class ChattGUI extends JFrame {

        JPanel bottompanel = new JPanel();
        JTextArea textArea = new JTextArea();
        JTextField textField = new JTextField();
        JScrollPane scrollp = new JScrollPane(textArea);
        JButton button = new JButton("Koppla ner");
        String namn;

        Klient klient;

        public ChattGUI(Klient klient) {
            this.klient=klient;
            namn = JOptionPane.showInputDialog("Ange namn");

            setSize(400, 400);
            setTitle(namn);
            bottompanel.setLayout(new BorderLayout());
            add(bottompanel);
            bottompanel.add(button, BorderLayout.NORTH);
            bottompanel.add(scrollp, BorderLayout.CENTER);
            bottompanel.add(textField, BorderLayout.SOUTH);

            button.addActionListener(klient);
            textField.addActionListener(klient);


            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

        }

        public void updateTextArea(String s){

            textArea.setText(textArea.getText()+s+"\n");
        }

    }

