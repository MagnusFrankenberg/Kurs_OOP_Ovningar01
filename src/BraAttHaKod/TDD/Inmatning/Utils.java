package BraAttHaKod.TDD.Inmatning;

import javax.swing.*;

public class Utils {

    protected int secretNumber;

    public Utils(int secretNumber){
        this.secretNumber = secretNumber;
    }

    public boolean compare(int userInput) {
        return (userInput == secretNumber);
    }

    public boolean doGame(boolean istest, int userMockInput) {
        if(istest){
            return compare(userMockInput);
        }
        else{
            String s = JOptionPane.showInputDialog(null, "Skriv en siffra");
            return compare(Integer.parseInt(s.trim()));
        }

    }

}
