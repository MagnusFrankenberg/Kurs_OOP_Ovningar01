package Sprint_2.Uppgift_9ab;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonAnalys_Test {

    PersonAnalys pa = new PersonAnalys();

    @Test
    public void trimArrayTest() {
        String[] s = {"Kalle Nilsson", " Xvägen 1", " 12345 Ystad"};

        assert (s[0].length() == 13);
        assert (s[1].length() == 9);
        assert (s[2].length() == 12);
        assert (s[1].charAt(0) == ' ');
        assert (s[1].equals(" Xvägen 1"));

        assert (pa.trimArray(s)[0].length() == 13);
        assert (pa.trimArray(s)[1].length() == 8);
        assert (pa.trimArray(s)[2].length() == 11);
        assert (pa.trimArray(s)[1].charAt(0) == 'X');
        assert (pa.trimArray(s)[1].equals("Xvägen 1"));

    }

    @Test
    public void stringToIntTest() {
        String[] s = {"25", " 80", " 175"};

        assert (pa.stringToInt(s)[0] == 25);
        assert (pa.stringToInt(s)[1] == 80);
        assert (pa.stringToInt(s)[2] == 175);
    }


    @Test
    public void createonePersonTest() {
        String row1 = "Kalle Nilsson, Xvägen 1, 12345 Ystad";
        String row2 = "25, 80, 175";
        Person p = pa.createonePerson(row1, row2);

        assert (p.namn.equals("Kalle Nilsson"));
        assert (p.gatuadress.equals("Xvägen 1"));
        assert (p.postort.equals("12345 Ystad"));
        assert (p.ålder == 25);
        assert (p.vikt == 80);
        assert (p.längd == 175);

        System.out.println(pa.createonePerson(row1, row2).toString());
    }

        @Test
        public void readFiletoListTest() {

            String filename = "src/Sprint_2/Uppgift_9a/personuppgifter.txt";

            assert (pa.readFiletoList(filename).size()==8);
            assert (pa.readFiletoList(filename).get(0).namn.equals("Kalle Nilsson"));
            assert (pa.readFiletoList(filename).get(1).gatuadress.equals("Xvägen 2"));
            assert (pa.readFiletoList(filename).get(2).postort.equals("12345 Ystad"));
            assert (pa.readFiletoList(filename).get(3).ålder==27);
            assert (pa.readFiletoList(filename).get(4).vikt==69);
            assert (pa.readFiletoList(filename).get(5).längd==205);
            assert (pa.readFiletoList(filename).get(6).längd==187);
            assert (pa.readFiletoList(filename).get(7).längd==175);

        }

        @Test
    public void långaPersonerTest() {

            List<Person> plist = new ArrayList<>(pa.readFiletoList("src/Sprint_2/Uppgift_9a/personuppgifter.txt"));

            assert (pa.långaPersoner(plist).size()==2);
            assert (pa.långaPersoner(plist).get(0).namn.equals("Rulle Rullson"));
            assert (pa.långaPersoner(plist).get(1).namn.equals("Nisse Nilsson"));
        }
    }







