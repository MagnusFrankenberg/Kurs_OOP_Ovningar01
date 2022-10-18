package Sprint_2.Uppgift_8b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Temperatur {

    public List<Double> fileToList(String filename) {
        Path p = Paths.get(filename);
        List<Double> lista = new ArrayList<>();
        double temp;
        try {
            Scanner in = new Scanner(p);
            while(in.hasNextDouble()) {
                temp = in.nextDouble();
                lista.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }


    public double getAverage(List<Double> lista) {
        double sum = 0, avg=0;
        for (int i = 0; i < lista.size(); i++) {
            sum += lista.get(i);
            avg = sum / lista.size();
        }
        return avg;
    }


    public Temperatur() {
        String filename = "src/Sprint_2/Uppgift_8a/temp.txt";
        List<Double> temperaturer = fileToList(filename);

        System.out.printf("Högsta temperatur är: %.01f\n" +
                        "Lägsta temperatur är: %.01f\n" +
                        "Medeltemperatur är: %.01f",
                        Collections.max(temperaturer),
                        Collections.min(temperaturer),
                        getAverage(temperaturer));
    }


    public static void main(String[] args) {
        Temperatur t = new Temperatur();
    }

}
