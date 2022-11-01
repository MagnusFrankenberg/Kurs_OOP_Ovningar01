package Sprint_3.Uppgift_5;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class StenSaxPåse implements ActionListener {


    Font myFont = new Font("Ink Free", Font.BOLD, 17);
    Font myFont2 = new Font("Ink Free", Font.BOLD, 14);
    Font myFont3 = new Font("Ink Free", Font.BOLD, 25);
    Color pink = new Color(255,180,170);
    Color BlueGreen = new Color(100,230,220);
    Color Green = new Color(0,153,0);
    JFrame frame = new JFrame("Sten Sax Påse");
    JPanel buttonPanelL1 = new JPanel();
    JPanel upperButtonPanel = new JPanel();
    JPanel lowerButtonPanel = new JPanel();
    JPanel scorePanelL1 = new JPanel();

    JButton computerButton1 = new JButton("STEN");
    JButton computerButton2 = new JButton("SAX");
    JButton computerButton3 = new JButton("PÅSE");

    JButton playerButton1 = new JButton("STEN");
    JButton playerButton2 = new JButton("SAX");
    JButton playerButton3 = new JButton("PÅSE");
    JButton finishButton = new JButton("Press to Exit");

    JLabel labelComputer = new JLabel("PLAYER: COMPUTER");
    JLabel labelPlayer = new JLabel("PLAYER: YOU");
    JLabel labelScoreComputer = new JLabel("<html> &#20 SCORE<br/>COMPUTER<html>", SwingConstants.CENTER);
    JLabel labelScorePlayer = new JLabel("<html> SCORE<br/> &#20 YOU<html>", SwingConstants.CENTER);
    JTextField tfscoreComputer = new JTextField("0", 1);
    int scoreComputer = 0;
    JTextField tfScorePlayer = new JTextField("0", 1);
    int scorePlayer = 0;

    JLabel labelSetWinner = new JLabel("PRESS A BUTTON!");


    JLabel labelGameWinner = new JLabel();


    public StenSaxPåse() {
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);


        //buttonpanel
        buttonPanelL1.setLayout(null);
        buttonPanelL1.setBounds(10, 10, 390, 360);
        buttonPanelL1.setBorder(new EtchedBorder());
        frame.add(buttonPanelL1);


        //scorepanel
        scorePanelL1.setLayout(null);
        scorePanelL1.setBounds(410, 10, 180, 360);
        scorePanelL1.setBorder(new EtchedBorder());
        frame.add(scorePanelL1);

        //upperbuttonpanel
        upperButtonPanel.setLayout(null);
        upperButtonPanel.setBounds(25, 70, 340, 70);
        upperButtonPanel.setBorder(new EtchedBorder());
        upperButtonPanel.setBackground(pink);
        buttonPanelL1.add(upperButtonPanel);

        //lowerButtonPanel
        lowerButtonPanel.setLayout(null);
        lowerButtonPanel.setBounds(25, 200, 340, 70);
        lowerButtonPanel.setBorder(new EtchedBorder());
        lowerButtonPanel.setBackground(BlueGreen);
        buttonPanelL1.add(lowerButtonPanel);

        //buttons
        computerButton1.setBounds(20, 10, 80, 50);
        computerButton2.setBounds(130, 10, 80, 50);
        computerButton3.setBounds(240, 10, 80, 50);
        upperButtonPanel.add(computerButton1);
        upperButtonPanel.add(computerButton2);
        upperButtonPanel.add(computerButton3);
        for (Component c : upperButtonPanel.getComponents())
            c.setFont(myFont);

        playerButton1.setBounds(20, 10, 80, 50);
        playerButton2.setBounds(130, 10, 80, 50);
        playerButton3.setBounds(240, 10, 80, 50);
        lowerButtonPanel.add(playerButton1);
        lowerButtonPanel.add(playerButton2);
        lowerButtonPanel.add(playerButton3);
        for (Component c : lowerButtonPanel.getComponents())
            c.setFont(myFont);

        finishButton.setBounds(100, 10, 160, 50);
        finishButton.setFont(myFont);
        finishButton.setVisible(false);
        lowerButtonPanel.add(finishButton);

        labelComputer.setBounds(95, 10, 250, 50);
        labelComputer.setFont(myFont);
        buttonPanelL1.add(labelComputer);


        labelPlayer.setBounds(95, 290, 250, 50);
        labelPlayer.setFont(myFont);
        buttonPanelL1.add(labelPlayer);


        labelScoreComputer.setBounds(35, 10, 110, 50);
        labelScoreComputer.setFont(myFont2);
        labelScoreComputer.setBorder(new EtchedBorder());
        scorePanelL1.add(labelScoreComputer);

        labelScorePlayer.setBounds(35, 290, 110, 50);
        labelScorePlayer.setFont(myFont2);
        labelScorePlayer.setBorder(new EtchedBorder());
        scorePanelL1.add(labelScorePlayer);

        tfscoreComputer.setBounds(45, 70, 90, 50);
        tfscoreComputer.setFont(myFont3);
        tfscoreComputer.setBorder(new MetalBorders.TextFieldBorder());
        tfscoreComputer.setHorizontalAlignment(JTextField.CENTER);
        scorePanelL1.add(tfscoreComputer);


        tfScorePlayer.setBounds(45, 230, 90, 50);
        tfScorePlayer.setFont(myFont3);
        tfScorePlayer.setBorder(new MetalBorders.TextFieldBorder());
        tfScorePlayer.setHorizontalAlignment(JTextField.CENTER);
        scorePanelL1.add(tfScorePlayer);

        labelSetWinner.setBounds(120, 150, 150, 35);
        labelSetWinner.setFont(myFont);
        labelSetWinner.setHorizontalAlignment(JLabel.CENTER);
        buttonPanelL1.add(labelSetWinner);

        labelGameWinner.setBounds(5, 150, 170, 50);
        labelGameWinner.setFont(myFont);
        labelGameWinner.setHorizontalAlignment(JLabel.CENTER);
        scorePanelL1.add(labelGameWinner);
        labelGameWinner.setVisible(false);


        JButton jb;
        for (Component c : upperButtonPanel.getComponents()) {
            jb = (JButton) c;
            jb.setBackground(Color.LIGHT_GRAY);
            jb.setOpaque(true);
        }
        for (Component c : lowerButtonPanel.getComponents()) {
            jb = (JButton) c;
            jb.addActionListener(this);
            jb.setOpaque(true);
        }


        frame.setVisible(true);

    }

    public String playGame(String computer, String player) {
        String result = null;
        switch (player) {
            case "STEN":
                switch (computer) {
                    case "STEN" -> result = "DRAW";
                    case "SAX" -> result = "YOU WIN";
                    case "PÅSE" -> result = "YOU LOOSE";

                }
                break;
            case "SAX":
                switch (computer) {
                    case "STEN" -> result = "YOU LOOSE";
                    case "SAX" -> result = "DRAW";
                    case "PÅSE" -> result = "YOU WIN";
                }
                break;
            case "PÅSE":
                switch (computer) {
                    case "STEN" -> result = "YOU WIN";
                    case "SAX" -> result = "YOU LOOSE";
                    case "PÅSE" -> result = "DRAW";
                }

        }
        return result;
    }

    public String computerChoice() {
        String choice = null;
        int i;
        Random r = new Random();
        i = r.nextInt(1, 4);
        switch (i) {
            case 1:
                choice = "STEN";
                computerButton1.setBackground(Color.RED);
                break;
            case 2:
                choice = "SAX";
                computerButton2.setBackground(Color.RED);
                break;
            case 3:
                choice = "PÅSE";
                computerButton3.setBackground(Color.RED);
        }
        return choice;
    }

    public boolean updateScore(String playresult) {
        boolean WehaveAWinner = false;
        if (playresult == "YOU WIN") {
            scorePlayer++;
            tfScorePlayer.setText(String.valueOf(scorePlayer));
        } else if (playresult == "YOU LOOSE") {
            scoreComputer++;
            tfscoreComputer.setText(String.valueOf(scoreComputer));
        }
        frame.revalidate();

        if (scorePlayer >= 3) {
            labelGameWinner.setText("YOU WIN!");
            labelGameWinner.setVisible(true);
            labelGameWinner.setForeground(Green);
            WehaveAWinner = true;
        }
        if (scoreComputer >= 3) {
            labelGameWinner.setText("COMPUTER WINS!");
            labelGameWinner.setVisible(true);
            labelGameWinner.setForeground(Color.RED);
            WehaveAWinner = true;
        }
        return WehaveAWinner;
    }

    public void labelWinnerColor(String playresult) {
        labelSetWinner.setOpaque(true);
        switch (playresult) {
            case "YOU WIN" -> labelSetWinner.setBackground(Green);
            case "DRAW" -> labelSetWinner.setBackground(null);
            case "YOU LOOSE" -> labelSetWinner.setBackground(Color.RED);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== finishButton){
            System.exit(0);
        }

        JButton jbut;
        for (Component c : upperButtonPanel.getComponents()) {
            jbut = (JButton) c;
            jbut.setBackground(null);
        }
        for (Component c : lowerButtonPanel.getComponents()) {
            jbut = (JButton) c;
            jbut.setBackground(null);
        }


        String playerChoice = null;
        JButton jb = null;

        if (e.getSource() == (jb = playerButton1)) {
            playerChoice = "STEN";
            jb.setBackground(Color.BLUE);
        } else if (e.getSource() == (jb = playerButton2)) {
            playerChoice = "SAX";
            jb.setBackground(Color.BLUE);
        } else if (e.getSource() == (jb = playerButton3)) {
            playerChoice = "PÅSE";
            jb.setBackground(Color.BLUE);
        }


        String playResult = playGame(computerChoice(), playerChoice);
        labelWinnerColor(playResult);
        labelSetWinner.setText(playResult);
        Boolean haveAWinner = updateScore(playResult);
        if (haveAWinner) {
            for (Component c : lowerButtonPanel.getComponents()) {
                jbut = (JButton) c;
                jbut.setVisible(false);
            }
            finishButton.setVisible(true);
            finishButton.addActionListener(this);
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       // UIManager.setLookAndFeel(
         //       UIManager.getCrossPlatformLookAndFeelClassName());

        StenSaxPåse ssp = new StenSaxPåse();
    }
}
