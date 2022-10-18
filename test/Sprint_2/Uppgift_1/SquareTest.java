package Sprint_2.Uppgift_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquareTest{

    Square square = new Square();

@Test

    public void squareTest(){

    square.width = 3;
    square.length = 4;

    assertTrue(square.getArea()==12);
    assertFalse(square.getArea()==0);

    assertTrue(square.getCircumference()==14);
    assertFalse(square.getCircumference()==0);

}


}
