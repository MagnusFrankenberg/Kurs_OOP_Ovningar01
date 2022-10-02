package Sprint_1.Uppgift_3b;

import java.util.*;

public class Lärare extends Person {
    private ArrayList<Kurs> minaKurser;

    public Lärare(String namn, String adress, String födelsedatum) {
        super(namn, adress, födelsedatum);
        minaKurser = new ArrayList<>();
    }

    public ArrayList<Kurs> getMinaKurser() {
        return minaKurser;
    }

    public void setMinaKurser(Kurs kurs) {
        this.minaKurser.add(kurs);
    }
}
