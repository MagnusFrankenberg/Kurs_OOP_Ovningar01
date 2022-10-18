package Sprint_2.Uppgift_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CirkelTest {

    Cirkel c = new Cirkel();

    @Test
    public void cirkelTest(){
        c.radie = 5;
        double r = c.radie;

        assertTrue(c.getArea()==Math.PI*r*r);
        assertFalse(c.getArea()==0);

        assertTrue(c.getCircumference()==2*Math.PI*r);
        assertFalse(c.getCircumference()==0);
    }
}
