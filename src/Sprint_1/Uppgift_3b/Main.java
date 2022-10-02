package Sprint_1.Uppgift_3b;

import java.io.*;
import java.util.*;


public class Main {

    //Skapar upp Studenter som inte ännu valt kurs och lägger i ArrayLista studenter (se textfil StudentData)
    public Main() throws FileNotFoundException, IOException {
        String fileName = "StudentData_Uppgift_3b.txt";
        Scanner input = new Scanner(new File(fileName));
        input.useDelimiter(",");

        ArrayList<Student> studenter = new ArrayList<>();
        while (input.hasNext()) {
            studenter.add(new Student(input.next().trim(), input.next().trim(), input.next().trim()));
        }
        input.close();

        //Skapar upp 3 Lärare som ännu inte undervisar i någon kurs
        ArrayList<Lärare> lärare = new ArrayList<>();

        lärare.add(new Lärare("Agneta", "Stora gatan 1", "690807"));
        lärare.add(new Lärare("Bosse", "Stora gatan 2", "790807"));
        lärare.add(new Lärare("Agnes", "Stora gatan 3", "650807"));

        //Skapar upp x antal Kurser utan Studenter och Lärare
        ArrayList<Kurs> kurser = new ArrayList<>();

        kurser.add(new Kurs("Biologi 1"));
        kurser.add(new Kurs("Psykologi 2"));
        kurser.add(new Kurs("Historia 3"));
        kurser.add(new Kurs("Programmering 1"));
        kurser.add(new Kurs("Filosofi 2"));


        //Lägger till 5-10 random studenter i varje kurs
        for (int i = 0; i < kurser.size(); i++) {
            kurser.get(i).setKlassLista(createRandomStudents(studenter));
        }

        //Lägger till en random lärare till varje kurs
        for (int i = 0; i < kurser.size(); i++) {
            Collections.shuffle(lärare);
            kurser.get(i).setLärare(lärare.get(0));
        }

        //Uppdaterar varje students kurslista
        for (int i = 0; i < kurser.size(); i++) {
            ArrayList<Student> klassen = kurser.get(i).getKlassLista();
            for (int j = 0; j < klassen.size(); j++) {
                klassen.get(j).setMinaKurser(kurser.get(i));
            }
        }

        //Uppdaterar varje lärares kurslista
        for (int i = 0; i < kurser.size(); i++) {
            Lärare enLärare = kurser.get(i).getLärare();
            enLärare.setMinaKurser(kurser.get(i));
        }

        //Anropar utskrift av varje Kurs
        for (int i = 0; i < kurser.size(); i++) {
            kurser.get(i).skrivUt();
        }

        //Anropar utskrift av varje student
        for (int i = 0; i < studenter.size(); i++) {
            studenter.get(i).skrivUt();
        }

    }


    public ArrayList<Student> createRandomStudents(ArrayList<Student> studenter) {
        Random r = new Random();
        int ri = r.nextInt(5, 11);
        Collections.shuffle(studenter);
        return new ArrayList<>(studenter.subList(0, ri));
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Main m = new Main();
    }
}
