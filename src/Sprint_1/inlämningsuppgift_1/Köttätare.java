package Sprint_1.inlämningsuppgift_1;


public class Köttätare extends Växt {

    public Köttätare(String namn, double längd) {
        super(namn, längd, Vätska.PROTEINDRYCK);
    }

    public double VätskeBehovPerDag() {
        double literVätska = 0.1 + (0.2 * getLängd());
        return literVätska;
    }

    public String printInstruktion() {
        String s = String.format("%s är en %s.\nDen behöver %.02f liter av %s",
                getNamn(),
                getClass().getSimpleName(),
                VätskeBehovPerDag(),
                getVätska().substans);
        return s;
    }
}
