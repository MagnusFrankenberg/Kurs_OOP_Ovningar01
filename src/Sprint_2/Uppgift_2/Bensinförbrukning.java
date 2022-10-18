package Sprint_2.Uppgift_2;

import javax.swing.*;

public class Bensinförbrukning {


    public double kördaMil(double mätStällDå, double mätStällNu) {
        return mätStällNu - mätStällDå;
    }


    public double förbrukningPerMil(double förbrukadBensin, double kördaMil) {
        return förbrukadBensin / kördaMil;
    }

    public String createString(double kördaMil, double förbrukadBensin, double förbrukPerMil) {
        StringBuilder sb = new StringBuilder("Antal körda mil: ");
        sb.append(String.format("%.01f\n", kördaMil));
        sb.append("Antal liter bensin: ");
        sb.append(String.format("%.01f\n", förbrukadBensin));
        sb.append("Förbrukning per mil: ");
        sb.append(String.format("%.02f", förbrukPerMil));
        String s = sb.toString();

        return s;
    }

    public double readAdouble(String message) {
        double aDouble = 0;
        Boolean försökigen = true;
        while (försökigen) {
            försökigen = false;
            try {
                aDouble = Double.parseDouble(JOptionPane.showInputDialog(message));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "fel format på input");
                försökigen = true;
            }
        }
        return aDouble;
    }
}
