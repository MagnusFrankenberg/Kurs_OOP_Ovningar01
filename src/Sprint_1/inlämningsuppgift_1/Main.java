package Sprint_1.inlämningsuppgift_1;

import javax.swing.*;

public class Main {

    public Main() {

        Gäster gäster = new Gäster();

        //Programmets Huvudmeny med 4 val
        while (true) {
            String väljare = JOptionPane.showInputDialog("Vad vill du göra? (Ange siffra)\n" +
                    "1: Checka in\n" +
                    "2: Checka ut\n" +
                    "3: Vattna\n" +
                    "4: Se lista på incheckade växter");

            if(väljare==null)
                break;

            switch (väljare) {
                case "1":
                    gäster.checkIn();
                    break;
                case "2":
                    gäster.checkOut();
                    break;
                case "3":
                    while (true) {
                        String namn = JOptionPane.showInputDialog(gäster.printGäster() + "\nVilken växt ska få vatten? (Ange namn)");
                        if (namn == null)
                            break;
                        Växt växt = gäster.hittaGäst(namn);
                        if (växt == null) {
                            JOptionPane.showMessageDialog(null, "Hittade ingen växt med det namnet");
                            continue;
                        }
                        JOptionPane.showMessageDialog(null, växt.bevattningsInstruktion());
                    }
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null,gäster.printGäster());
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Otillåten input, försök igen");


            }
        }
    }
        public static void main (String[]args){
            Main m = new Main();
        }
    }
