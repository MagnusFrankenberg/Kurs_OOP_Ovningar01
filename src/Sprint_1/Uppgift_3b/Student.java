package Sprint_1.Uppgift_3b;

import java.util.*;

public class Student extends Person {

    private ArrayList<Kurs> minaKurser;

    public Student(String namn, String adress, String födelsedatum) {
        super(namn, adress, födelsedatum);
        minaKurser = new ArrayList<>();

    }

    public ArrayList<Kurs> getMinaKurser() {
        return minaKurser;
    }

    public void setMinaKurser(Kurs kurs) {
        this.minaKurser.add(kurs);
    }

    public void skrivUt() {
        System.out.printf("Studentens namn: %s\n", getNamn());

        for (Kurs k : minaKurser) {
            System.out.printf("Kurs: %s, Lärare: %s\n", k.getKursNamn(), k.getLärare().getNamn());
        }
        System.out.println("\n_______________________");
    }
}