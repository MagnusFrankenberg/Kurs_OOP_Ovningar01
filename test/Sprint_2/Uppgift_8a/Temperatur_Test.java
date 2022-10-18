package Sprint_2.Uppgift_8a;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Temperatur_Test {

    Temperatur t = new Temperatur();


    @Test

    public void convertToDoubleTest() {
        String s = "1,4";
        assert (t.convertToDouble(s)==1.4);
    }



    @Test
    public void fileToListTest(){
        String filename = "src/Sprint_2/Uppgift_8a/temp.txt";
        assert (t.fileToList(filename).get(0)==13.3);
        assert (t.fileToList(filename).get(1)==14.5);
        assert (t.fileToList(filename).get(2)==17.5);
        assert (t.fileToList(filename).get(3)==12.8);

    }

    @Test
    public void getAverageTest(){
        List<Double> lista = Arrays.asList(10.0,10.0,5.0,5.0);
        assert (t.getAverage(lista)==7.5);
    }
}
