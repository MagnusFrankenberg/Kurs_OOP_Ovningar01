package Sprint_2.Uppgift_4;

import javax.swing.*;
import java.util.Scanner;

public class Bensinförbrukning {


    public double kördaMil(double mätStällDå, double mätStällNu) {
        return mätStällNu - mätStällDå;
    }


    public double förbrukningPerMil(double förbrukadBensin, double kördaMil) {
        return förbrukadBensin / kördaMil;
    }

    public String createString(double kördaMil, double förbrukadBensin, double förbrukPerMil) {
        StringBuilder sb = new StringBuilder("Antal körda mil: ");
        sb.append(String.format("%.0f\n", kördaMil));
        sb.append("Antal liter bensin: ");
        sb.append(String.format("%.01f\n", förbrukadBensin));
        sb.append("Förbrukning per mil: ");
        sb.append(String.format("%.02f", förbrukPerMil));
        String s = sb.toString();

        return s;
    }

    public double readAdouble(String message) {
        Scanner sc = new Scanner(System.in);
        double aDouble = 0;

        while (true) {
            System.out.println(message);
            if (sc.hasNextDouble()) {
                aDouble = sc.nextDouble();
                break;
            }else{
                sc.next();
                System.out.println("Fel format på input");
            }
        }
        return aDouble;
    }
}
