package Sprint_1.Uppgift_1a;

public class Bil {

    private Bilägare ägare;
    private String regnummer;
    private String märke;
    private String modell;

    public Bil(String regnummer, String märke, String modell) {
        this.regnummer = regnummer;
        this.märke = märke;
        this.modell = modell;
    }

    public Bil(Bilägare ägare, String regnummer, String märke, String modell) {
        this.ägare = ägare;
        this.regnummer = regnummer;
        this.märke = märke;
        this.modell = modell;
    }

    public void setÄgare(Bilägare ägare) {
            this.ägare = ägare;
    }

    public void bytÄgare(Bilägare köpare) {
        this.ägare = köpare;
    }

    public String getRegnummer() {
        return regnummer;
    }

    public void setRegnummer(String regnummer) {
        this.regnummer = regnummer;
    }

    public String getMärke() {
        return märke;
    }

    public void setMärke(String märke) {
        this.märke = märke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public Bilägare getÄgare() {
        return ägare;
    }



    }




