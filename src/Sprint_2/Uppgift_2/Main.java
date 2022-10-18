package Sprint_2.Uppgift_2;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Bensinförbrukning b = new Bensinförbrukning();

        double mätareDå = b.readAdouble("Ange mätarställning Y-1 (mil)");
        double mätareNu = b.readAdouble("Ange mätarställning idag (mil)");
        double bensin1år = b.readAdouble("Ange hur mycket bensin som förbrukats på ett år");

        double kördaMil = b.kördaMil(mätareDå,mätareNu);
        double förbrukningPerMil = b.förbrukningPerMil(bensin1år,kördaMil);

        String s = b.createString(kördaMil,bensin1år,förbrukningPerMil);

        System.out.println(s);



    }
}
