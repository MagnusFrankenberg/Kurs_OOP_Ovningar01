package Sprint_1.temporary;

import java.time.*;
import java.util.*;


public class Testkod {

    public Testkod(){

        String s = "2014-05-01";
        String e = "2014-05-10";
        LocalDate start = LocalDate.parse(s);
        LocalDate end = LocalDate.parse(e);
        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }


    }
}
