package Sprint_1.Uppgift_10;

public abstract class Bankprodukt {
    private String idNummer;

    public Bankprodukt(String idNummer) {
        this.idNummer = idNummer;
    }

    public String getIdNummer() {
        return idNummer;
    }
}
