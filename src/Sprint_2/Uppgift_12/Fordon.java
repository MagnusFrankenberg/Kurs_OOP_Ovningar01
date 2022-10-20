package Sprint_2.Uppgift_12;

import java.io.Serializable;

public abstract class Fordon implements Printable, Serializable {
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
