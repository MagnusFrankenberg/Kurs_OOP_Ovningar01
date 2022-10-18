package Sprint_1.Uppgift_10;

public class Lån extends Bankprodukt{
    private LåneTyp låneTyp;
    private String låneNummer;
    private double belopp;
    private double räntesats;

    public Lån(String idNummer, LåneTyp låneTyp, double belopp, double räntesats) {
        super(idNummer);
        this.låneTyp = låneTyp;
        this.låneNummer = idNummer;
        this.belopp = belopp;
        this.räntesats = räntesats;
    }

    public LåneTyp getLåneTyp() {
        return låneTyp;
    }


    public String getLåneNummer() {
        return låneNummer;
    }


    public double getBelopp() {
        return belopp;
    }

    public void setBelopp(double belopp) {
        this.belopp = belopp;
    }

    public double getRäntesats() {
        return räntesats;
    }

    public void setRäntesats(double räntesats) {
        this.räntesats = räntesats;
    }
}
