package Sprint_1.Uppgift_10;

public class Ersättning {
    private double månadsLön;
    private double bonusProcent;

    public Ersättning(double månadsLön, double bonusProcent) {
        this.månadsLön = månadsLön;
        this.bonusProcent = bonusProcent;
    }

    public double getMånadsLön() {
        return månadsLön;
    }

    public double getÅrsBonus() {
        return bonusProcent;
    }

    public double totalÅrsKompensation(){
        return (12*månadsLön)+(12*månadsLön)*bonusProcent/(double) 100;
    }
}
