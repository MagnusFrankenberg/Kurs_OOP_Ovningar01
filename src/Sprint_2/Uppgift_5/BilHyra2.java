package Sprint_2.Uppgift_5;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

import java.util.*;

public class BilHyra2 {
    public static void main(String[] arg) {

        while (true) {

            String indata = showInputDialog
                    ("Ange antal dagar, pris per dag samt bilmodell");
            Scanner sc;
            try {
                 sc = new Scanner(indata);
            }catch (NullPointerException e){
                JOptionPane.showMessageDialog(null,"Programmet avslutas");
                break;
            }

            int antalDagar;
            try {
                antalDagar = sc.nextInt();
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null,"Fel format på antal dagar, måste vara ett heltal");
                sc.next();
                continue;
            }catch (NoSuchElementException e){
                JOptionPane.showMessageDialog(null,"Input för antal dagar saknas");
                continue;
            }

            double dagsPris;
            try{
                dagsPris = sc.nextDouble();
            }catch (InputMismatchException e){
                JOptionPane.showMessageDialog(null,"Fel format på pris per dag, måste vara ett tal");
                sc.next();
                continue;
            }catch (NoSuchElementException e){
                JOptionPane.showMessageDialog(null,"Input för dagspris saknas");
                continue;
            }

            String bil;
            try {
                bil = sc.next();
            }catch (NoSuchElementException e){
                JOptionPane.showMessageDialog(null,"Input för bilmodell saknas");
                continue;
            }

            double totPris = dagsPris * antalDagar;

            String s = String.format("Totalt pris för %s: %.2f",
                    bil, totPris);
            showMessageDialog(null, s);
        }


    }
}
