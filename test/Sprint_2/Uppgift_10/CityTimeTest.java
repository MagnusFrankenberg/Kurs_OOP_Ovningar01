package Sprint_2.Uppgift_10;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class CityTimeTest {


    CityTime ct = new CityTime(true);

    @Test
    void createCityObject() {
        String[] array = {"Toronto", "America/Toronto"};
        System.out.println(ct.createCityObject(array).toString());

    }


    @Test
    void readFileToList() {



        String filename = "src/Sprint_2/Uppgift_10/timezones.txt";
        assert (ct.readFileToList(filename).size()==3);
        assert (ct.readFileToList(filename).get(0).getName().equals("Toronto"));
        assert (ct.readFileToList(filename).get(1).getName().equals("Stockholm"));
        assert (ct.readFileToList(filename).get(2).getName().equals("Shanghai"));
    }

    @Test
    void processInput() {

        System.out.println(ct.processInput("sTOCKHOLM"));
        System.out.println(ct.processInput(" tORONTO "));
        assert (ct.processInput(" tORONTO ").equals("Toronto"));


    }

    @Test
    void getLocalNowTime() {
        ZoneId zone1 = ZoneId.of("America/Toronto");
        ZoneId zone2 = ZoneId.of("Europe/Stockholm");
        ZoneId zone3 = ZoneId.of("Asia/Shanghai");

        System.out.println(ct.getLocalNowTime(zone1));
        System.out.println(ct.getLocalNowTime(zone2));
        System.out.println(ct.getLocalNowTime(zone3));
    }
}