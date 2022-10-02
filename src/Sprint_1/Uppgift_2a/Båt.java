package Sprint_1.Uppgift_2a;

public class Båt extends Fordon{
    private double dödvikt;

    public Båt(double hastighet, double vikt, double dödvikt) {
        super(hastighet, vikt);
        this.dödvikt = dödvikt;
    }

    public void sväng(int grader, String riktning){
        System.out.println("Svänger "+grader+" grader "+riktning);
    }

    public double getDödvikt() {
        return dödvikt;
    }
}
