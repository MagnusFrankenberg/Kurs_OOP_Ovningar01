package Sprint_3.Lektion_1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TestComponent extends JFrame {

    int boardsize;
    int squares;

    JPanel bottomPanel = new JPanel();

    List<Component> buttons = new ArrayList<>();
    List<Component> positions = new ArrayList<>();


    public TestComponent(int boardsize){
        this.boardsize = boardsize;
        this.squares = boardsize * boardsize;

        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(boardsize, boardsize, 3, 3));
        add(bottomPanel);

        //lägger till 16 positioner (JPanel-objekt) på bottomPanel och lägger dem i listan positions
        for (int i = 0; i < squares; i++) {
            positions.add(new JPanel());
            JPanel jp = (JPanel) positions.get(i);
            jp.setName(String.valueOf(i + 1));  //ger varje JPanel ett namn från "1"-"16"
            jp.setLayout(new GridLayout());
            bottomPanel.add(jp);
        }

        //skapar upp 16 buttons-objekt och lägger i listan buttons
        for (int i = 0; i < squares; i++) {
            buttons.add(new JButton(String.valueOf(i)));   //ger varje JButton en knapptext från "1"-"16"
            JButton jb = (JButton)buttons.get(i);
        }

        for (int i = 0; i < squares; i++) {
           JPanel jp = (JPanel) positions.get(i);
           JButton jb =(JButton) buttons.get(i);
           jp.add(jb);
        }


    }








    public static void main(String[] args) {
        TestComponent t = new TestComponent(Integer.parseInt(JOptionPane.showInputDialog("Ange storlek")));
    }
}
