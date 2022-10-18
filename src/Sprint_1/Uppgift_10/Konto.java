package Sprint_1.Uppgift_10;

public class Konto extends Bankprodukt {
    private KontoTyp kontoTyp;
    private String kontoNummer;
    private double saldo;
    private double räntesats;

    public Konto(String idNummer, KontoTyp kontoTyp, double saldo, double räntesats) {
        super(idNummer);
        this.kontoTyp = kontoTyp;
        this.kontoNummer = idNummer;
        this.saldo = saldo;
        this.räntesats = räntesats;
    }
}
