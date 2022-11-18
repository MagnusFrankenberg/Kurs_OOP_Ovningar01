package Sprint_4.Uppg_8;

import java.io.Serializable;

public class Intro implements Serializable {

    String meddelande;

    public Intro() {
        meddelande = "Connection med server är upprättad\nAnge namn:";
    }

    @Override
    public String toString() {
        return meddelande;
    }
}
