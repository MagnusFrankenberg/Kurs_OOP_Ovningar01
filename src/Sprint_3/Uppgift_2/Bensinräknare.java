package Sprint_3.Uppgift_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Bensinräknare extends JFrame implements ActionListener {
    double mätareNu = 0, mätareDå = 0, förbruk1år = 0;

    //Lager 0:
    JPanel bottomPanel = new JPanel();

    //Lager 1:
    JPanel southL1 = new JPanel();
    JPanel northL1 = new JPanel();

    //Lager 2:
    JPanel westL2 = new JPanel();
    JPanel centerL2 = new JPanel();

    //till westpanel:
    JLabel labMätareNu = new JLabel("Ange mätarställning nu:");
    JLabel labMätareDå = new JLabel("Ange mätarställning för ett år sedan:");
    JLabel labFörbruk1år = new JLabel("Ange antal liter förbrukad bensin:");

    //till centerpanel:
    JTextField tfMätareNu = new JTextField();
    JTextField tfMätareDå = new JTextField();
    JTextField tfFörbruk1år = new JTextField();

    /// till southPanel:
    String stringKördaMil = "Antal körda mil: ";
    JLabel labKördaMil = new JLabel(stringKördaMil);
    String stringLiterBensin = "Antal liter bensin: ";
    JLabel labLiterBensin = new JLabel(stringLiterBensin);
    String stringFörbrukningPerMil = "Förbrukning per mil:  ";
    JLabel labFörbrukningPerMil = new JLabel(stringFörbrukningPerMil);


    public Bensinräknare() {
        bottomPanel.setLayout(new BorderLayout());
        add(bottomPanel);
        northL1.setLayout(new BorderLayout());
        southL1.setLayout(new GridLayout(1, 3));
        bottomPanel.add(northL1, BorderLayout.NORTH);
        bottomPanel.add(southL1, BorderLayout.SOUTH);
        westL2.setLayout(new GridLayout(3, 1));
        centerL2.setLayout(new GridLayout(3, 1));
        northL1.add(westL2, BorderLayout.WEST);
        northL1.add(centerL2, BorderLayout.CENTER);
        westL2.add(labMätareNu);
        westL2.add(labMätareDå);
        westL2.add(labFörbruk1år);
        centerL2.add(tfMätareNu);
        centerL2.add(tfMätareDå);
        centerL2.add(tfFörbruk1år);
        southL1.add(labKördaMil);
        southL1.add(labLiterBensin);
        southL1.add(labFörbrukningPerMil);

        tfMätareNu.addActionListener(this);
        tfMätareDå.addActionListener(this);
        tfFörbruk1år.addActionListener(this);

        pack();
        setSize(500, 125);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();


            Scanner sc1 = new Scanner(tfMätareNu.getText());
            mätareNu = sc1.nextDouble();


            Scanner sc2 = new Scanner(tfMätareDå.getText());
            mätareDå = sc2.nextDouble();


            Scanner sc3 = new Scanner(tfFörbruk1år.getText());
            förbruk1år = sc3.nextDouble();


        double kördaMil = (mätareNu - mätareDå);
        double literBensin = förbruk1år;
        double förbrukPerMil = literBensin / kördaMil;

        stringKördaMil = String.format("Antal körda mil: %.01f", kördaMil);
        stringLiterBensin = String.format("Antal liter bensin: %.01f", literBensin);
        stringFörbrukningPerMil = String.format("Förbrukning per mil: %.01f", förbrukPerMil);

        if(mätareNu!=0&&mätareDå!=0&&förbruk1år!=0) {
            labKördaMil.setText(stringKördaMil);
            labLiterBensin.setText(stringLiterBensin);
            labFörbrukningPerMil.setText(stringFörbrukningPerMil);
        }
    }

    public static void main(String[] args) {
        Bensinräknare br = new Bensinräknare();
    }
}