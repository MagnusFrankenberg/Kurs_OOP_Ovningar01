package Sprint_3.Uppgift_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BeräknaVäxelGUI extends JFrame implements ActionListener {
    VäxelTillbaka v = new VäxelTillbaka();

    //Layer 0
    JPanel bottomPanel = new JPanel();

    //Layer 1
    JPanel northL1 = new JPanel();
    JPanel northL2 = new JPanel();
    JPanel centerL1 = new JPanel();
    JPanel southL1 = new JPanel();

    //Layer 2:
    //northL1
    JLabel labAngePris = new JLabel("Ange Pris: ");
    JLabel labAngeBetalning = new JLabel("Ange Betalning: ");
    JTextField tfAngePris = new JTextField();
    int pris;
    JTextField tfAngeBetalning = new JTextField();
    int betalning;
    JLabel labVilkaValörer = new JLabel("Kryssa i önskade valörer i växel:");

    JCheckBox cb1000 = new JCheckBox("1000-lappar");
    JCheckBox cb500 = new JCheckBox("500-lappar");
    JCheckBox cb200 = new JCheckBox("200-lappar");
    JCheckBox cb100 = new JCheckBox("100-lappar");
    JCheckBox cb50 = new JCheckBox("50-lappar");
    JCheckBox cb20 = new JCheckBox("20-lappar");
    JCheckBox cb10 = new JCheckBox("10-kronor");
    JCheckBox cb5 = new JCheckBox("5-kronor");
    JCheckBox cb2 = new JCheckBox("2-kronor");
    JCheckBox cb1 = new JCheckBox("1-kronor");

    boolean[] önskeValörer = new boolean[10];

    JButton butBeräkna = new JButton("Beräkna Växel");

    JLabel labSvar = new JLabel("Du ska få tillbaka:");


    public BeräknaVäxelGUI() {
        bottomPanel.setLayout(new BorderLayout());
        add(bottomPanel);

        northL1.setLayout(new BorderLayout());
        centerL1.setLayout(new GridLayout(6, 2));
        southL1.setLayout(new BorderLayout());

        bottomPanel.add(northL1, BorderLayout.NORTH);
        bottomPanel.add(centerL1, BorderLayout.CENTER);
        bottomPanel.add(southL1, BorderLayout.SOUTH);

        northL2.setLayout(new GridLayout(3, 2));
        northL1.add(northL2, BorderLayout.CENTER);

        northL2.add(labAngePris);
        northL2.add(tfAngePris);
        northL2.add(labAngeBetalning);
        northL2.add(tfAngeBetalning);
        northL1.add(labVilkaValörer, BorderLayout.SOUTH);

        centerL1.add(cb1000);
        centerL1.add(cb20);
        centerL1.add(cb500);
        centerL1.add(cb10);
        centerL1.add(cb200);
        centerL1.add(cb5);
        centerL1.add(cb100);
        centerL1.add(cb2);
        centerL1.add(cb50);
        centerL1.add(cb1);

        butBeräkna.addActionListener(this);
        southL1.add(butBeräkna, BorderLayout.CENTER);

        southL1.add(labSvar, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public boolean[] hämtaÖnskadeValörer() {
        boolean[] bArray = new boolean[10];

        bArray[0] = cb1000.isSelected();
        bArray[1] = cb500.isSelected();
        bArray[2] = cb200.isSelected();
        bArray[3] = cb100.isSelected();
        bArray[4] = cb50.isSelected();
        bArray[5] = cb20.isSelected();
        bArray[6] = cb10.isSelected();
        bArray[7] = cb5.isSelected();
        bArray[8] = cb2.isSelected();
        bArray[9] = cb1.isSelected();


        return bArray;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == butBeräkna) {

            Scanner sc1 = new Scanner(tfAngePris.getText());
            this.pris = sc1.nextInt();

            Scanner sc2 = new Scanner(tfAngeBetalning.getText());
            this.betalning = sc2.nextInt();


            this.önskeValörer = hämtaÖnskadeValörer();
            runVäxeltillbaka();

        }
    }

    public void runVäxeltillbaka(){
        int totalväxel = v.totalVäxel(pris, betalning);
        if(totalväxel<=0){
            skrivSvar(v.ejNågonVäxel(totalväxel));
        }else {
            v.växelList = v.beräknaVäxelTillbaka(totalväxel, önskeValörer);
            skrivSvar(v.skapaVäxelString(v.växelList));
        }
    }

    public void skrivSvar(String svar) {
        labSvar.setText("<html>Du ska få tillbaka: <br/><html>" + svar);
    }

    public static void main(String[] args) {

        BeräknaVäxelGUI bv = new BeräknaVäxelGUI();

    }
}