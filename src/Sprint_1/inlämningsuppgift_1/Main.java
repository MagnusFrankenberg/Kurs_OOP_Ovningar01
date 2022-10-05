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

            //Anrop av metod baserat på val i huvudmenyn
            switch (väljare) {
                case "1":
                    gäster.checkIn();
                    break;
                case "2":
                    gäster.checkOut();
                    break;
                case "3":
                    vattna(gäster);
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null,gäster.printGäster());
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Otillåten input, försök igen");


            }
        }
    }

    //metod vattna:
    // Frågar efter ett namn, letar upp motsvarande Växtobjekt, och genererar bevattningsinstruktion
    //polymorfism -> kommer köra den metod "bevattningsinstruktion" som ligger i motsvarande Växtobjekts klass.
    public void vattna(Gäster gäster){
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
    }
        public static void main (String[]args){
            Main m = new Main();
        }
    }
