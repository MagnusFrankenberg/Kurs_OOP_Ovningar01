package Sprint_2.Uppgift_6ab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VäxelTillbaka {

    List<Integer> allaValörer = Arrays.asList(1000, 500, 200, 100, 50, 20, 10, 5, 2, 1);
    List<Integer> växelList;



    public String ejNågonVäxel(int totalväxel){
        String s="";
        if(totalväxel<0) {
            s = "Du lämnade för lite pengar";
        }
        else if(totalväxel==0){
            s = "Det blev ingen växel";
        }
        return s;
    }

    public int totalVäxel(int pris, int betalning) {
        return betalning - pris;
    }

    public int getAntal(int tempväxel, int valör) {
        return tempväxel / valör;
    }

    public int kvarAttväxla(int tempväxel, int valör) {
        return tempväxel % valör;
    }


    public List<Integer> beräknaVäxelTillbaka(int totalVäxel) {
        List<Integer> växelTillbaka = new ArrayList<>();
        int tempväxel = totalVäxel;
        int antal = 0;
        for (int i = 0; i < allaValörer.size(); i++) {
            int valör = allaValörer.get(i);
            antal = getAntal(tempväxel, valör);
            växelTillbaka.add(antal);
            tempväxel = kvarAttväxla(tempväxel, valör);
        }
        return växelTillbaka;
    }

    public String getIntLapparKronor(int v) {
        String s = "Antal ";
        if (v >= 20) {
            s += v + "-lappar:";
        } else {
            s += v + "-kronor:";
        }
        return s;
    }




    public String skapaVäxelString(List<Integer> växellista) {
        String s="";
        int valör;
        int antal;
        for (int i = 0; i < allaValörer.size(); i++) {
            valör = allaValörer.get(i);
            antal= växellista.get(i);
            if(antal>0){
                s += String.format("%s %d\n",getIntLapparKronor(valör),antal);
            }
        }
        return s;
    }
}


