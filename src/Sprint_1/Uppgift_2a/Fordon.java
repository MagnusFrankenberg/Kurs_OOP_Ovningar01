package Sprint_1.Uppgift_2a;

public class Fordon {
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
}
