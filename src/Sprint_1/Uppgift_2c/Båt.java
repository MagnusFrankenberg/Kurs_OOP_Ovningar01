package Sprint_1.Uppgift_2c;

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

    public void printMe() {
        String cname = this.getClass().getSimpleName() + ":";
        System.out.printf("%s \n" +
                "Hastighet: %.01f\n" +
                "Vikt: %.02f\n" +
                "Dödvikt: %.01f\n", cname, getHastighet(), getVikt(), getDödvikt());
    }
}
