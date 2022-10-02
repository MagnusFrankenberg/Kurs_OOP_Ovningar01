package Sprint_1.Uppgift_2d;

public abstract class Fordon implements Printable {
    private double hastighet;
    private double vikt;

    public Fordon(){}

    public Fordon(double hastighet, double vikt) {
        this.hastighet = hastighet;
        this.vikt = vikt;
    }

    public void ändraHastighet(double nyHastighet){
        hastighet = nyHastighet;
    }

    public double getHastighet() {
        return hastighet;
    }

    public double getVikt() {
        return vikt;
    }

    //abstract void printMe();
}
