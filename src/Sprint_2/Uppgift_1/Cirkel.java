package Sprint_2.Uppgift_1;

public class Cirkel implements Figure {
    double radie;


    @Override
    public double getArea() {
        return Math.PI*radie*radie;
    }

    @Override
    public double getCircumference() {
        return 2*Math.PI*radie;
    }
}
