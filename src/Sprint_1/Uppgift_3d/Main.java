package Sprint_1.Uppgift_3d;

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

        //Skapar upp lista med deltagande-objekt
        ArrayList<Deltagande> deltarLista = new ArrayList<>();

        for (int i = 0; i < kurser.size(); i++) {
            ArrayList<Student> randomKlass = createRandomStudents(studenter);
            Lärare enLärare = randomLärare(lärare);
            kurser.get(i).setLärare(enLärare);
            for (int j = 0; j < randomKlass.size(); j++) {
                deltarLista.add(new Deltagande(randomKlass.get(j), kurser.get(i)));
            }
        }

        //Print studenter
        for (Student s : studenter) {
            System.out.printf("\nStudent: %s\nKurser:\n",s.getNamn());
            for (Deltagande d : deltarLista) {
                if (s.equals(d.getStudent()))
                    System.out.printf("%s  (Lärare: %s)\n",d.getKurs().getKursNamn(),d.getKurs().getLärare().getNamn());
            }
            System.out.println("----------------------------------");
        }
        System.out.println("\n----------------------------------\n----------------------------------\n");

        //Print Kurser
        for(Kurs k:kurser){
            System.out.printf("\nKurs: %s,\tLärare: %s\nStudenter:\n",k.getKursNamn(),k.getLärare().getNamn()); //fixa lärarproblemet, kan ej nå deltagarlistan
            for(Deltagande d:deltarLista){
                if(k.equals(d.getKurs()))
                    System.out.printf("Namn: %s,\tAdress: %s\n",d.getStudent().getNamn(), d.getStudent().getAdress());
            }
            System.out.println("____________________");
        }

        //print lärare
        for(Lärare l:lärare){
            System.out.printf("Lärare: %s\nKurser: \n",l.getNamn());
            for(Kurs k:kurser){
                if(l.equals(k.getLärare()))
                    System.out.printf("%s \n",k.getKursNamn());
            }
            System.out.println("____________________");
        }


    }

    public ArrayList<Student> createRandomStudents(ArrayList<Student> studenter) {
        Random r = new Random();
        int ri = r.nextInt(5, 11);
        Collections.shuffle(studenter);
        return new ArrayList<>(studenter.subList(0, ri));
    }

    public Lärare randomLärare(ArrayList<Lärare> lärareLista){
        Collections.shuffle(lärareLista);
        return lärareLista.get(0);
    }




    public static void main(String[] args) throws FileNotFoundException, IOException {
        Main m = new Main();
    }
}
