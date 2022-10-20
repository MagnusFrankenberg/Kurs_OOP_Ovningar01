package Sprint_2.Uppgift_12;

import javax.swing.*;

public class ObjectCreator {

    public int processIntInput(String message) {
        boolean försökigen = true;
        int input = 0;
        while (försökigen) {
            try {
                input = Integer.parseInt(JOptionPane.showInputDialog(message));
                försökigen = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Otillåten input, försök igen");
            }
        }
        return input;
    }

    public double processDoubleInput(String message) {
        boolean försökigen = true;
        double input = 0;
        while (försökigen) {
            try {
                input = Double.parseDouble(JOptionPane.showInputDialog(message));
                försökigen = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Otillåten input, försök igen");
            }
        }
        return input;
    }


    public Fordon createObject() {
        Fordon fordon = null;
        boolean tryagain = false;
        do {
            String option = JOptionPane.showInputDialog("Vilken fordonstyp vill du skapa? (Ange siffra)\n" +
                    "(1) Bil\n" +
                    "(2) Båt\n" +
                    "(3) Cykel\n" +
                    "(4) Tåg");

            if(option==null) {
                break;
            }

            switch (option) {
                case "1": {
                    int hastighet = processIntInput("Ange hastighet");
                    double vikt = processDoubleInput("Ange vikt");
                    int antalVäxlar = processIntInput("Ange antal växlar");
                    int växelJustNu = processIntInput("Ange nuvarande växel");
                    int antalHjul = processIntInput("Ange antal hjul");
                    fordon = new Bil(hastighet, vikt, antalVäxlar, växelJustNu, antalHjul);
                    break;
                }
                case "2": {
                    double hastighet = processDoubleInput("Ange hastighet");
                    double vikt = processDoubleInput("Ange vikt");
                    double dödvikt = processDoubleInput("Ange dödvikt");
                    fordon = new Båt(hastighet, vikt, dödvikt);
                    break;
                }

                case "3": {
                    double hastighet = processDoubleInput("Ange hastighet");
                    double vikt = processDoubleInput("Ange vikt");
                    int antalVäxlar = processIntInput("Ange antal växlar");
                    int växelJustNu = processIntInput("Ange nuvarande växel");
                    int antalHjul = processIntInput("Ange antal hjul");
                    fordon = new Cykel(hastighet, vikt, antalVäxlar, växelJustNu, antalHjul);
                    break;
                }

                case "4": {
                    double hastighet = processDoubleInput("Ange hastighet");
                    double vikt = processDoubleInput("Ange vikt");
                    int antalVagnar = processIntInput("Ange antal vagnar");
                    fordon = new Tåg(hastighet, vikt, antalVagnar);
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "Otillåten input");
                    tryagain=true;
                }
            }
        }while(tryagain);
        return fordon;
    }
}
