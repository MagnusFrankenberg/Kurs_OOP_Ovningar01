package Sprint_1.inlämningsuppgift_1;

import javax.swing.*;
import java.util.*;

//Denna klass innehåller en List "nuvarandeGäster" med de Växt-objekt som för närvarande är incheckade på hotellet.
//Klassen innehåller 4 metoder:
// 1. hittaGäst -> som returnerar ett Växtobjekt baserat på växtens namn
// 2. checkIn -> tar in nödvändig info om en ny gäst (Namn, längd, typ), kontrollerar för ev fel i input,
//...skapar sedan upp nytt objekt och lägger i listan "nuvarandeGäster".
// 3. checkOut -> tar in namnet på växt som ska checkas ut, och raderar växten från listan "nuvarandeGäster".
// 4. printGäster -> returnerar en String med incheckade växter (namn + typ).

public class Gäster {

    private List<Växt> nuvarandeGäster = new ArrayList<>();

    //Metod för att returnera ett incheckat Växtobjekt baserat på växtens namn
    public Växt hittaGäst(String namn) {
        Växt växt = null;
        for (int i = 0; i < nuvarandeGäster.size(); i++) {
            if (namn.equals(nuvarandeGäster.get(i).getNamn()))
                växt = nuvarandeGäster.get(i);
        }
        return växt;
    }

    //Metod för att checka in nya växtobjekt
    //Tar in nödvändig info via showInputDialog i 3 steg: namn, längd, typ.
    //Kontrollerar indatans giltighet och skapar nya objekt som läggs till en ArrayList
    public void checkIn() {

        //tar in namn:
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

        //tar in längd:
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

        //tar in typ av växt:
        do {
            försökIgen = false;
            String input = JOptionPane.showInputDialog("Ange typ av växt (Ange siffra)\n" +
                    "1: Palm\n" +
                    "2: Köttätare\n" +
                    "3: Kaktus");

            //skapar upp objekt av vald Typ och lägger till i List "nuvarandeGäster"
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

    //metod för att checka ut en växt
    //letar efter angivet namn och tar bort Växt-objektet från List
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

    //metod som returnerar en String med incheckade Gäster (namn & typ)
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


