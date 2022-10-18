package Sprint_2.Uppgift_4;

import Sprint_2.Uppgift_4.Bensinförbrukning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BensinförbrukningTest {

    Sprint_2.Uppgift_4.Bensinförbrukning b = new Bensinförbrukning();

    @Test
    public void bensinförbrukningTest(){

        double msNu = 1255.5;
        double msDå = 1000.0;
        double förbrukadBensin = 511;

        assertTrue(b.kördaMil(msDå,msNu)==255.5);
        assertFalse(b.kördaMil(msDå,msNu)==0);

        double kördaMil = b.kördaMil(msDå,msNu);

        assertTrue(b.förbrukningPerMil(förbrukadBensin,kördaMil)==2);
        assertFalse(b.förbrukningPerMil(förbrukadBensin,kördaMil)==0);

        double förbrukPerMil = b.förbrukningPerMil(förbrukadBensin,kördaMil);

        String s = b.createString(kördaMil,förbrukadBensin,förbrukPerMil);
        System.out.println(s);

        double aDouble = b.readAdouble("Ange mätarställning Y-1 (mil)");
        System.out.println(aDouble);

    }

}
