package Sprint_1.inlämningsuppgift_1;

public abstract class Växt implements Vätskeinstruktion {

    //Använder mig av private, samt get-metoder för att uppnå enkapsulation
    private String namn;
    private double längd;
    private Vätska vätska;  //Enum som ligger i filen Vätska.java

    public Växt(String namn, double längd, Vätska vätska) {
        this.namn = namn;
        this.längd = längd;
        this.vätska = vätska;
    }

    public String getNamn() {
        return namn;
    }

    public double getLängd() {
        return längd;
    }

    public Vätska getVätska() {
        return vätska;
    }

    //Abstrakt metod som returnerar vätskebehovet
    //implementeras i subklasserna med relevant kod för varje växttyp
    abstract public double VätskeBehovPerDag();


    //En implementation av den abstrakta metoden från Interface Vätskeinstruktion,
    //Denna metod kommer att ärvas av subklasserna
    //returnerar en String med bevattningsinstruktion
    public String bevattningsInstruktion() {
        String s = String.format("%s är en %s.\nDen behöver %.02f liter av %s",
                getNamn(),
                getClass().getSimpleName(),
                VätskeBehovPerDag(),
                getVätska().substans);
        return s;
    }
}
