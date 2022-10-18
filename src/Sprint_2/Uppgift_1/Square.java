package Sprint_2.Uppgift_1;

public class Square implements Figure {

    int width;
    int length;

    @Override
    public double getArea() {
        return (double) width * length;
    }

    @Override
    public double getCircumference() {
        return (double) (2 * width + 2 * length);
    }
}
