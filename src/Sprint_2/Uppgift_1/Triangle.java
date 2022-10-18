package Sprint_2.Uppgift_1;

public class Triangle implements Figure {

    int width;
    int height;


    @Override
    public double getArea() {
        return (double) ((width * height) / 2);
    }

    @Override
    public double getCircumference() {
        double c = Math.sqrt((((double) width/2)*((double) width/2))+ (height*height));
        return c+width+height;
    }
}
