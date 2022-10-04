package Sprint_1.inlämningsuppgift_1;

import javax.swing.*;
import java.util.*;

public class Gäster {

    private List<Växt> nuvarandeGäster = new ArrayList<>();

    public Växt hittaGäst(String namn) {
        Växt växt = null;
        for (int i = 0; i < nuvarandeGäster.size(); i++) {
            if (namn.equals(nuvarandeGäster.get(i).getNamn()))
                växt = nuvarandeGäster.get(i);
        }
        return växt;
    }

    public void checkIn() {

        String namn;
        Boolean ärUpptaget = false;
        do {
            ärUpptaget = false;
            namn = JOptionPane.showInputDialog("Ange växtens namn");
            for (Växt v : nuvarandeGäster) {
                if (v.getNamn().equals(namn)) {
                    JOptionPane.showMessageDialog(null, "Namnet redan registrerat," +
                            " välj ett annat namn");
                    ärUpptaget = true;
                }
            }
        } while (ärUpptaget);

        Boolean försökIgen = false;
        double längd = 0;
        do {
            försökIgen = false;
            try {
                längd = Double.parseDouble(JOptionPane.showInputDialog("Ange växtens längd"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Otillåten input, försök igen");
                försökIgen = true;
            }
        } while (försökIgen);


        do {
            försökIgen = false;

            String input = JOptionPane.showInputDialog("Ange typ av växt (Ange siffra)\n" +
                    "1: Palm\n" +
                    "2: Köttätare\n" +
                    "3: Kaktus");



            switch (input) {
                case "1":
                    nuvarandeGäster.add(new Palm(namn, längd));
                    break;
                case "2":
                    nuvarandeGäster.add(new Köttätare(namn, längd));
                    break;
                case "3":
                    nuvarandeGäster.add(new Kaktus(namn, längd));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Otillåten input, försök igen");
                    försökIgen = true;
            }
        } while (försökIgen);
    }

    public void checkOut() {
        Boolean hittatGäst = false;
        String namn = JOptionPane.showInputDialog(printGäster() + "\nAnge namn på Växt som ska checkas ut");
        for (int i = 0; i < nuvarandeGäster.size(); i++) {
            if (namn.equals(nuvarandeGäster.get(i).getNamn())) {
                hittatGäst = true;
                nuvarandeGäster.remove(i);
                JOptionPane.showMessageDialog(null, "Har nu checkat ut " + namn);
                break;
            }
        }
        if (hittatGäst == false) {
            JOptionPane.showMessageDialog(null, "Kunde inte hitta någon planta med namnet " + namn);
        }
    }

    public String printGäster() {
        String s = "Nuvarande gäster:\n";
        for (int i = 0; i < nuvarandeGäster.size(); i++) {
            s += String.format("%d. %s (%s)\n",
                    i + 1,
                    nuvarandeGäster.get(i).getNamn(),
                    nuvarandeGäster.get(i).getClass().getSimpleName());
        }
        return s;
    }
}


