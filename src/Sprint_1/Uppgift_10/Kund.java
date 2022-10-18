package Sprint_1.Uppgift_10;

public class Kund extends Person{

    private String kundNr;

    public Kund(String namn, String adress, String personnummer) {
        super(namn, adress, personnummer);
        this.kundNr = "k"+personnummer;
    }
}
