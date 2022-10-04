package Sprint_1.inlämningsuppgift_1;


public class Kaktus extends Växt{

    public Kaktus(String namn, double längd) {
        super(namn, längd, Vätska.MINERALVATTEN);
    }

    public double VätskeBehovPerDag(){
        double literVätska = 0.02;
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
