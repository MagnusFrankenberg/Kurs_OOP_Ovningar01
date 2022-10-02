package Sprint_1.Uppgift_3b;

import java.util.*;

public class Kurs {

    private String kursNamn;
    private ArrayList<Student> klassLista;
    private Lärare lärare;

    public Kurs(String kursNamn) {
        this.kursNamn = kursNamn;
        klassLista = new ArrayList<>();
    }

    public void setKlassLista(ArrayList<Student> klassLista) {
        this.klassLista = klassLista;
    }

    public void setLärare(Lärare lärare) {
        this.lärare = lärare;
    }

    public String getKursNamn() {
        return kursNamn;
    }

    public ArrayList<Student> getKlassLista() {
        return klassLista;
    }

    public Lärare getLärare() {
        return lärare;
    }

    public void skrivUt() {
        System.out.printf("Kursnamn: %s\nLärare: %s\n\nStudenter:\n", kursNamn, lärare.getNamn());

        for (Student s : klassLista) {
            System.out.printf("%s, %s, %s\n", s.getNamn(), s.getAdress(), s.getFödelsedatum());
        }
        System.out.println("\n_______________________");
    }


}
