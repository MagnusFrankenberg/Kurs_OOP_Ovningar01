package Sprint_2.Uppgift_6c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VäxelTillbaka {

    List<Integer> allaValörer = Arrays.asList(1000, 500, 200, 100, 50, 20, 10, 5, 2, 1);
    List<Integer> växelList;



    public String ejNågonVäxel(int totalväxel){
        StringBuilder sb = new StringBuilder();
        if(totalväxel<0) {
             sb = new StringBuilder("Du lämnade för lite pengar");
        }
        else if(totalväxel==0){
             sb = new StringBuilder("Det blev ingen växel");
        }
      return sb.toString();
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
        StringBuilder sb = new StringBuilder("Antal ");
        if (v >= 20) {
            sb.append(String.format("%d-lappar:",v));
        } else {
            sb.append(String.format("%d-kronor:",v));
        }
        return sb.toString();
    }




    public String skapaVäxelString(List<Integer> växellista) {
        StringBuilder sb = new StringBuilder();
        int valör;
        int antal;
        for (int i = 0; i < allaValörer.size(); i++) {
            valör = allaValörer.get(i);
            antal= växellista.get(i);
            if(antal>0){
                sb.append(String.format("%s %d\n",getIntLapparKronor(valör),antal));
            }
        }
        return sb.toString();
    }
}


