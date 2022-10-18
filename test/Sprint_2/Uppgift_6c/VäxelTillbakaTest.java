package Sprint_2.Uppgift_6c;

import Sprint_2.Uppgift_6ab.VäxelTillbaka;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VäxelTillbakaTest {

    VäxelTillbaka vtb = new VäxelTillbaka();


    @Test
    public void växelTillbakaTest() {

        int pris = 122;
        int betalning = 1000;

        assertTrue(vtb.totalVäxel(pris, betalning) == 878);
        assertFalse(vtb.totalVäxel(pris, betalning) == 0);

        int totalVäxel = vtb.totalVäxel(pris, betalning);


        assertTrue(vtb.beräknaVäxelTillbaka(totalVäxel).get(1) == 1);
        assertTrue(vtb.beräknaVäxelTillbaka(totalVäxel).get(2) == 1);
    }

    @Test
    public void getIntLapparKronor_Test() {
        System.out.println(vtb.getIntLapparKronor(1000));
        System.out.println(vtb.getIntLapparKronor(500));
        System.out.println(vtb.getIntLapparKronor(1));
        System.out.println(vtb.getIntLapparKronor(5));
        System.out.println(vtb.getIntLapparKronor(2));
    }

    @Test
    public void skapaVäxelString_Test() {
        List<Integer> testlista = Arrays.asList(0,1,0,1,3,1,4,1,1,0);
        System.out.println(vtb.skapaVäxelString(testlista));
    }

    @Test
    public void ejNågonVäxel_Test(){
        System.out.println(vtb.ejNågonVäxel(-5));
        System.out.println(vtb.ejNågonVäxel(0));
        System.out.println(vtb.ejNågonVäxel(400));
    }


}
