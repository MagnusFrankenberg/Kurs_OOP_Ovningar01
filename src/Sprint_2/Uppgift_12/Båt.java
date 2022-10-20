package Sprint_2.Uppgift_12;

public class Båt extends Fordon implements Printable {
    private double dödvikt;

    public Båt(double hastighet, double vikt, double dödvikt) {
        super(hastighet, vikt);
        this.dödvikt = dödvikt;
    }

    public void sväng(int grader, String riktning) {
        System.out.println("Svänger " + grader + " grader " + riktning);
    }

    public double getDödvikt() {
        return dödvikt;
    }

    public String printMe() {
        String cname = this.getClass().getSimpleName() + ":";
        String s = String.format("%s \n" +
                "Hastighet: %.01f\n" +
                "Vikt: %.02f\n" +
                "Dödvikt: %.01f\n", cname, getHastighet(), getVikt(), getDödvikt());
        return s;
    }
}
