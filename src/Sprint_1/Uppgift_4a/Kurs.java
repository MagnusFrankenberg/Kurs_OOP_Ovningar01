package Sprint_1.Uppgift_4a;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kurs {

    private String kursNamn;
    private Lärare lärare;

    private String startDate;
    private String endDate;

    private List<LocalDate> schema;

    public Kurs(String kursNamn, String startDate, String endDate) {
        this.kursNamn = kursNamn;
        this.startDate = startDate;
        this.endDate = endDate;
        schema = createSchedule();
    }

    public void setLärare(Lärare lärare) {
        this.lärare = lärare;
    }

    public String getKursNamn() {
        return kursNamn;
    }

    public Lärare getLärare() {
        return lärare;
    }

    public List<LocalDate> getSchema() {
        return schema;
    }

    public List<LocalDate> createSchedule() {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        Random r = new Random();
        int addDays = r.nextInt(1,7);
        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            totalDates.add(start.plusDays(addDays));
            start = start.plusDays(7);
        }
        return totalDates;

    }

    public void skrivUt() {

    }


}
