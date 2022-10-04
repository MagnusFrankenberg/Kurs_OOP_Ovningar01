package Sprint_1.inlämningsuppgift_1;


public class Palm extends Växt{
    public Palm(String namn, double längd) {
        super(namn, längd, Vätska.KRANVATTEN);
    }

    public double VätskeBehovPerDag(){
        double literVätska = 0.5 * getLängd();
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
