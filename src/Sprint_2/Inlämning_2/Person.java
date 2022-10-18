package Sprint_2.Inlämning_2;

import java.time.LocalDate;

public class Person {

    private String personnummer;
    private String name;
    private LocalDate senastBetaldAvgift;

    public Person(String personnummer, String name, LocalDate senastBetaldAvgift) {
        this.personnummer = personnummer;
        this.name = name;
        this.senastBetaldAvgift = senastBetaldAvgift;
    }

    public String getName() {
        return name;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public LocalDate getSenastBetaldAvgift() {
        return senastBetaldAvgift;
    }

    public void setSenastBetaldAvgift(LocalDate senastBetaldAvgift) {
        this.senastBetaldAvgift = senastBetaldAvgift;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)",name,personnummer);
    }
}
