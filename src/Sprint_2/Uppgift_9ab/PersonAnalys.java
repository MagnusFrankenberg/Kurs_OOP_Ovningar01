package Sprint_2.Uppgift_9ab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonAnalys {

    String sökväg = "src/Sprint_2/Uppgift_9ab/";
    String filename1;
    String filename2;

    public static void main(String[] args) {
        PersonAnalys pa = new PersonAnalys();
    }

    public PersonAnalys() {

        filename1 = sökväg + läsfilNamn("Ange filnamn att läsa in från (namn.txt)", true);
        filename2 = sökväg + läsfilNamn("Ange filnamn att skriva till (namn.txt)", false);

        List<Person> allapersoner = readFiletoList(filename1);
        List<Person> långapersoner = långaPersoner(allapersoner);
        skrivLångaTillFil(långapersoner, filename2);

    }


    public String[] trimArray(String[] s) {
        String temp;
        String[] out = new String[3];
        for (int i = 0; i < s.length; i++) {
            temp = s[i].trim();
            out[i] = temp;
        }
        return out;
    }

    public int[] stringToInt(String[] s) {
        int temp;
        int[] out = new int[3];
        for (int i = 0; i < s.length; i++) {
            temp = Integer.parseInt(s[i].trim());
            out[i] = temp;
        }
        return out;
    }


    public Person createonePerson(String row1, String row2) {
        String[] r1 = row1.split(",");
        r1 = trimArray(r1);

        String[] r2 = row2.split(",");
        int[] i2 = stringToInt(r2);

        Person p = new Person(r1[0], r1[1], r1[2], i2[0], i2[1], i2[2]);
        return p;
    }

    public List<Person> readFiletoList(String filename) {
        List<Person> lista = new ArrayList<>();
        String row1;
        String row2;
        try (BufferedReader buf = new BufferedReader(new FileReader(filename))) {
            while ((row1 = buf.readLine()) != null && (row2 = buf.readLine()) != null) {
                lista.add(createonePerson(row1, row2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Person> långaPersoner(List<Person> allaPersoner) {
        List<Person> långaPersoner = new ArrayList<>();
        for (Person p : allaPersoner) {
            if (p.längd > 200) {
                långaPersoner.add(p);
            }
        }
        return långaPersoner;
    }

    public void skrivLångaTillFil(List<Person> lista, String filename) {
        try (PrintWriter ut = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Person p : lista) {
                ut.println(p.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String läsfilNamn(String message, Boolean ärläsfil) {
        String namn = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(message);
            namn = sc.nextLine();
            if (namn.isEmpty())
                continue;

            if (ärläsfil && !existerarFil(this.sökväg + namn)) {
                System.out.println("Kunde inte hitta filen: " + this.sökväg + namn);
                continue;
            }
            break;
        }
        return namn;
    }

    public Boolean existerarFil(String filePathString) {
        Path path = Paths.get(filePathString);
        if (Files.exists(path)) {
            return true;
        } else {
            return false;
        }
    }

}

