package Sprint_1.Uppgift_1c;

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

    public String getMärke() {
        return märke;
    }

    public String getRegnummer() {
        return regnummer;
    }
    public Bilägare getÄgare() {
        return ägare;
    }



    }




