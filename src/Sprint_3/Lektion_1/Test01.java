package Sprint_3.Lektion_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Scanner;

public class Test01 extends JFrame implements ActionListener {

    JPanel bottomPane = new JPanel();
    JLabel labAngeText = new JLabel("Ange antal:");
    JTextField tfAngeText = new JTextField(10);
    JButton jbKnapp = new JButton("Tryck här");
    JCheckBox cb1 = new JCheckBox("Äpplen");
    JCheckBox cb2 = new JCheckBox("Päron");
    JCheckBox cb3 = new JCheckBox("Bananer");
    JCheckBox cb4 = new JCheckBox("Kiwis");
    JCheckBox cb5 = new JCheckBox("Druvor");
    JCheckBox cb6 = new JCheckBox("Apelsiner");
    JCheckBox cb7 = new JCheckBox("Kokosnötter");
    JCheckBox cb8 = new JCheckBox("Jordgubbar");
    JCheckBox cb9 = new JCheckBox("Mandariner");
    JCheckBox cb10 = new JCheckBox("Mangofrukter");
    JLabel labSvar = new JLabel("Du vill ha ");


    public Test01() {
        bottomPane.setLayout(new FlowLayout());
        add(bottomPane);
        bottomPane.add(labAngeText);
        bottomPane.add(tfAngeText);
        bottomPane.add(jbKnapp);

        bottomPane.add(cb1);
        bottomPane.add(cb2);
        bottomPane.add(cb3);
        bottomPane.add(cb4);
        bottomPane.add(cb5);
        bottomPane.add(cb6);
        bottomPane.add(cb7);
        bottomPane.add(cb8);
        bottomPane.add(cb9);
        bottomPane.add(cb10);

        bottomPane.add(labSvar);
        jbKnapp.addActionListener(this);

        pack();
        setSize(300, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public String createSvar() {
        String s = "";
        String varor = "";
        Scanner sc = new Scanner(tfAngeText.getText());
        int antal = sc.nextInt();


        //skapa ny lista av Typen checkbox
        ArrayList<JCheckBox> boxes = new ArrayList<>();

        //lägger alla checkboxes i en lista
        for (int i = 0; i < bottomPane.getComponentCount(); i++) {
            if (bottomPane.getComponent(i) instanceof JCheckBox) {
                boxes.add((JCheckBox) bottomPane.getComponent(i));
            }
        }

        //kör igenom listan av checkboxes och tar dess namn
        for (JCheckBox cb : boxes) {
            if (cb.isSelected()) {
                varor += cb.getText() + ",<br/>";
            }
        }
        s = String.format("<html>Du vill ha %d stycken av:<br/> %s<html>", antal, varor);
        return s;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jbKnapp) {
            labSvar.setText(createSvar());
        }

    }

    public static void main(String[] args) {
        Test01 t1 = new Test01();
    }
}
