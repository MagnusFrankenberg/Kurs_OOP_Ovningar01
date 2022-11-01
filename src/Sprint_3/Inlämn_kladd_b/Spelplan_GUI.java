package Sprint_3.Inlämn_kladd_b;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Spelplan_GUI implements ActionListener {

    int boardsize;
    int squares;

    JPanel klickedPosition;


    JFrame frame = new JFrame("15-spel");
    JPanel bottomPanel = new JPanel();
    Font myFont1 = new Font("Ink Free", Font.BOLD, 17);
    Color BlueGreen = new Color(100, 230, 220);

    List<JButton> buttons = new ArrayList<>();
    List<JPanel> positions = new ArrayList<>();


    public Spelplan_GUI(int boardsize) {
        this.boardsize = boardsize;
        this.squares = boardsize * boardsize;


        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        bottomPanel.setLayout(new GridLayout(boardsize, boardsize, 3, 3));
        frame.add(bottomPanel);

        //lägger till 16 positioner (JPanel-objekt) på bottomPanel och lägger dem i listan positions
        for (int i = 0; i < squares; i++) {
            positions.add(new JPanel());
            positions.get(i).setName(String.valueOf(i + 1));  //ger varje JPanel ett namn från "1"-"16"
            positions.get(i).setLayout(new GridLayout());
            bottomPanel.add(positions.get(i));
        }

        //skapar upp 16 buttons-objekt och lägger i listan buttons
        for (int i = 0; i < squares; i++) {
            buttons.add(new JButton(String.valueOf(i)));   //ger varje JButton en knapptext från "1"-"16"
            buttons.get(i).setFont(myFont1);
            buttons.get(i).setBackground(BlueGreen);
            buttons.get(i).addActionListener(this);
        }
        //sätter button 0 == osynlig, detta blir den tomma rutan
        buttons.get(0).setVisible(false);

        //shufflar buttons-listan
        Collections.shuffle(buttons);

        //lägger till shufflade buttons på positionerna (en button på varje JPanel)
        for (int i = 0; i < squares; i++) {
            positions.get(i).add(buttons.get(i));
        }

        //frame.pack();
        frame.setVisible(true);

    }

    //hitta tom position (=hitta button med text "0" och returnera JPanel som den ligger på)
    public JPanel findEmptyPosition() {
        JPanel emptyposition = null;
        JButton button;
        for (int i = 0; i < squares; i++) {
            button = ((JButton) positions.get(i).getComponent(0));
            if (button.getText().equals("0")) {
                emptyposition = positions.get(i);
            }
        }
        return emptyposition;
    }

    //kollar om det är tillåtet att flytta från en position till den tomma positionen
    public boolean isPermittedSwap(JPanel emptyposition, JPanel tryFromPosition) {
        //skapar integers av positionsnumren
        int emptyPos = Integer.parseInt(emptyposition.getName());
        int tryFromPos = Integer.parseInt(tryFromPosition.getName());

        // identifierar rad och kolumn för tom ruta:
        int emptyPosRow = ((emptyPos - 1) / boardsize) + 1;
        int emptyPosCol = ((emptyPos - 1) % boardsize) + 1;

        // identifierar rad och kolumn för tryfrom position:
        int tryFromRow = ((tryFromPos - 1) / boardsize) + 1;
        int tryFromCol = ((tryFromPos - 1) % boardsize) + 1;

        boolean isPermitted = false;
        if (emptyPosCol == tryFromCol) {
            if (Math.abs(emptyPosRow - tryFromRow) == 1) {
                isPermitted = true;
            }
        } else if (emptyPosRow == tryFromRow) {
            if (Math.abs(emptyPosCol - tryFromCol) == 1) {
                isPermitted = true;
            }
        }
        return isPermitted;
    }

    public boolean makeAMove(JPanel klickedPos) {
        boolean movedSuccesfully = false;
        if (isPermittedSwap(findEmptyPosition(), klickedPos)) {
            JButton empty = ((JButton) findEmptyPosition().getComponent(0));
            JButton klicked = ((JButton) klickedPos.getComponent(0));

            empty.setText(klicked.getText());
            empty.setVisible(true);

            klicked.setText("0");
            klicked.setVisible(false);
            //här behövs kod för att byta nummer på buttons och ändra visibility status


            //denna kod är för att kolla så koden funkar, tas bort sedan.
            //JOptionPane.showMessageDialog(null, "Det är tillåtet att flytta bricka nr: " + ((JButton)klickedPos.getComponent(0)).getText());
            movedSuccesfully = true;
        }
        return movedSuccesfully;
    }

    public boolean gameCompleted() {
        boolean completed = true;
        for (int i = 0; i < squares - 1; i++) {
            String buttonNo = ((JButton) positions.get(i).getComponent(0)).getText();
            String positionNo = String.valueOf(i + 1);
            if (!buttonNo.equals(positionNo)) {
                completed = false;
                break;
            }
        }
        return completed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //kollar vilken knapp tom tryckts
        for (int i = 0; i < squares; i++) {
            if (buttons.get(i) == e.getSource()) {
                klickedPosition = (JPanel) buttons.get(i).getParent();

                //Testutskrift för att se om funktionaliteten funkar
                // JOptionPane.showMessageDialog(null, "Du tryckte på knapp: " + buttons.get(i).getText() +
                //        "\nsom ligger på position "+klickedPosition.getName());

                makeAMove(klickedPosition);
                if(gameCompleted()){
                    JOptionPane.showMessageDialog(null, "Congrats! You have completed the Game!");

                    int dialogbutton = JOptionPane.YES_NO_OPTION;
                    JOptionPane.showConfirmDialog(null,"Play Again?","", dialogbutton);
                    if(dialogbutton==JOptionPane.YES_NO_OPTION){
                        new Spelplan_GUI(Integer.parseInt(JOptionPane.showInputDialog("Ange önskat antal rutor (ange antal rutor per rad)")));
                    }else{
                        System.exit(0);
                    }


                }

            }
        }
    }
}
