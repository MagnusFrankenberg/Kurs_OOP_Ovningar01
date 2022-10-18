package Sprint_1.Uppgift_10;

import java.util.Random;

public class StödMetoder {

    public String skapaIdNummer(String prefix, int antalSiffror){
        Random random = new Random();
        String s =prefix;
        for (int i = 0; i <antalSiffror ; i++) {
            s+= (random.nextInt(1,11)-1);
        }
        return s;
    }
}
