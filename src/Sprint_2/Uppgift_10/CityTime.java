package Sprint_2.Uppgift_10;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityTime {

    List<City> cities;
    String filename;
    Boolean isTest;

    public static void main(String[] args) {
        CityTime ct = new CityTime(false);
    }

    public CityTime(Boolean isTest) {
        this.isTest = isTest;

        if (!isTest) {
            cities = new ArrayList<>();
            filename = "src/Sprint_2/Uppgift_10/timezones.txt";
            cities = readFileToList(filename);

            while (true) {
                String indata = processInput(null);
                createMessage(indata);
            }
        }
    }

    public String[] trimArray(String[] s) {
        String temp;
        String[] out = new String[2];
        for (int i = 0; i < s.length; i++) {
            temp = s[i].trim();
            out[i] = temp;
        }
        return out;
    }


    public City createCityObject(String[] sArray) {
        String name = sArray[0];
        ZoneId zone = ZoneId.of(sArray[1]);
        City city = new City(name, zone);
        return city;
    }


    public List<City> readFileToList(String filename) {
        List<City> cityList = new ArrayList<>();
        Path p = Paths.get(filename);
        String[] row = new String[2];
        try {
            Scanner in = new Scanner(p);
            while (in.hasNextLine()) {
                row = in.nextLine().split(",");
                row = trimArray(row);
                cityList.add(createCityObject(row));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityList;
    }


    public String processInput(String testinput) {
        String input;
        if (isTest) {
            input = testinput;
        } else {
            input = JOptionPane.showInputDialog("Vad är klockan? Skriv in en stad");
        }
        input = input.trim().toLowerCase();
        input = input.substring(0, 1).toUpperCase() + input.substring(1);
        return input;
    }


    public String getLocalNowTime(ZoneId zone) {
        Instant nowUTC = Instant.now();
        ZonedDateTime nowLocalZone = ZonedDateTime.ofInstant(nowUTC, zone);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String localTime = dtf.format(nowLocalZone);
        return localTime;
    }

    public City returnCity(String input) {
        City city = null;
        for (City c : cities) {
            if (c.getName().equals(input))
                city = c;
        }
        return city;
    }


    public void createMessage(String input) {
        if (returnCity(input) == null) {
            JOptionPane.showMessageDialog(null, "Info om " + input + " ej tillgänglig.\nförsök med en annan stad");
        } else {
            JOptionPane.showMessageDialog(null, "Klockan är " + getLocalNowTime(returnCity(input).getZone()) + " i " + input);
        }
    }


}
