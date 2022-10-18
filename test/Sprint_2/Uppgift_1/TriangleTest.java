package Sprint_2.Uppgift_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {

    Triangle t = new Triangle();

    @Test
    public void triangleTest(){
        t.width = 7;
        t.height = 5;
        System.out.println(t.getCircumference());

        assertTrue(t.getArea()==12);
        assertFalse(t.getArea()==0);

        assertTrue(t.getCircumference()==15);
        assertFalse(t.getCircumference()==0);

    }
}
