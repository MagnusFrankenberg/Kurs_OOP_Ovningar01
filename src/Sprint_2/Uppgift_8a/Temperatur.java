package Sprint_2.Uppgift_8a;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Temperatur {

    public double convertToDouble(String s) {
        double d = Double.parseDouble(s.replace(",", "."));
        return d;
    }


    public List<Double> fileToList(String filename) {
        List<Double> lista = new ArrayList<>();
        String temp;
        try (BufferedReader buf = new BufferedReader(new FileReader(filename))) {
            while ((temp = buf.readLine()) != null) {
                lista.add(convertToDouble(temp));
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
