package Sprint_1.Uppgift_3d;

import java.util.ArrayList;

public class Kurs {

    private String kursNamn;
    private Lärare lärare;

    public Kurs(String kursNamn) {
        this.kursNamn = kursNamn;
    }

    public void setLärare(Lärare lärare) {
        this.lärare = lärare;
    }

    public String getKursNamn() {
        return kursNamn;
    }

    public Lärare getLärare() {
        return lärare;
    }

    public void skrivUt() {

    }


}
