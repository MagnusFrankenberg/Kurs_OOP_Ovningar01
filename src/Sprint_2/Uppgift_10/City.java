package Sprint_2.Uppgift_10;

import java.time.ZoneId;

public class City {

    private String name;
    private ZoneId zone;

    public City(String name, ZoneId zone) {
        this.name = name;
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public ZoneId getZone() {
        return zone;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", zone=" + zone +
                '}';
    }
}