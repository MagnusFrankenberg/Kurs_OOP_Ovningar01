package Sprint_1.Uppgift_3a;

import java.util.*;
import java.io.*;

public class Main {


    public Main()  {

        //Skapar upp 10 Studenter som inte ännu valt kurs och lägger i array students[].

        Student[] students = new Student[100];

        students[0] = new Student("Magnus", "Lilla gatan 1", "890706");
        students[1] = new Student("Lisa", "Lilla gatan 2", "990706");
        students[2] = new Student("Greta", "Lilla gatan 3", "790706");
        students[3] = new Student("Lars", "Lilla gatan 4", "990506");
        students[4] = new Student("Olle", "Lilla gatan 5", "970306");
        students[5] = new Student("Micke", "Lilla gatan 6", "850706");
        students[6] = new Student("Adrian", "Lilla gatan 7", "910706");
        students[7] = new Student("Lotta", "Lilla gatan 8", "770706");
        students[8] = new Student("Henrik", "Lilla gatan 9", "920506");
        students[9] = new Student("Viktor", "Lilla gatan 10", "810306");

        //Skapar upp 3 Lärare som ännu inte undervisar i någon kurs
        Lärare[] lärare = new Lärare[100];
        int antalLärare = 3;

        lärare[0] = new Lärare("Agneta", "Stora gatan 1", "690807");
        lärare[1] = new Lärare("Bosse", "Stora gatan 2", "790807");
        lärare[2] = new Lärare("Agnes", "Stora gatan 3", "650807");


        //Skapar upp x antal Kurser utan Studenter och Lärare
        Kurs[] kurser = new Kurs[100];

        kurser[0] = new Kurs("Biologi 1");
        kurser[1] = new Kurs("Psykologi 2");
        kurser[2] = new Kurs("Historia 3");
        kurser[3] = new Kurs("Programmering 1");
        kurser[4] = new Kurs("Filosofi 2");

        //Lägger till 5 random studenter i varje kurs
        for (int i = 0; i < kurser.length; i++) {
            if (kurser[i] == null)
                break;
            for (int j = 0; j < 5; j++) {
                kurser[i].setKlasslista(createRandomStudents(students));
            }
        }

        //Lägger till en random lärare till varje kurs
        Random r = new Random();
        for (int i = 0; i < kurser.length; i++) {
            if (kurser[i] == null)
                break;
            int ri = r.nextInt(1, antalLärare+1) - 1;
            kurser[i].setLärare(lärare[ri]);
        }

        //Uppdaterar varje students kurslista
        for (int i = 0; i < kurser.length; i++) {
            if (kurser[i] == null) break;
            Student[] klassen = kurser[i].getKlasslista();
            for (int j = 0; j < klassen.length; j++) {
                if (klassen[j] == null) break;
                klassen[j].setStudentensKurser(kurser[i]);
            }
        }


        //Uppdaterar varje lärares kurslista
        for (int i = 0; i < kurser.length; i++) {
            if (kurser[i] == null) break;
            Lärare l = kurser[i].getLärare();
            l.setLärarensKurser(kurser[i]);
        }

        //Anropar utskrift av varje Kurs
        for (int i = 0; i < kurser.length; i++) {
            if (kurser[i] == null) break;
            kurser[i].skrivUt();
        }

        //Utskrift av varje student
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) break;
            students[i].skrivUt();
        }

    }


    //metod för att skapa en grupp av 5 unika studenter från de 10 tillgängliga studenterna i Students[]
    public Student[] createRandomStudents(Student[] students) {
        //create unique random numbers btw 0-9 (number of available students)
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) list.add(i);
        Collections.shuffle(list);

        //create array with 5 random students
        Student[] randomStudenter = new Student[100];
        for (int i = 0; i < 5; i++) {
            randomStudenter[i] = students[list.get(i)];
        }
        return randomStudenter;
    }


    public static void main(String[] args) {

        Main m = new Main();
    }
}

