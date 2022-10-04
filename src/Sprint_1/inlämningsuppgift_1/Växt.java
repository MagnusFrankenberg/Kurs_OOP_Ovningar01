package Sprint_1.inlämningsuppgift_1;

public abstract class Växt implements Vätskeinstruktion {

    private String namn;
    private double längd;
    private Vätska vätska;

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

    abstract public double VätskeBehovPerDag();


}
