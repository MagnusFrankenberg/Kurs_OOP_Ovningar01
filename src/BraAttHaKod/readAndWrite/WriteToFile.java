package BraAttHaKod.readAndWrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteToFile {


    public WriteToFile() {


        //try with resources för att undvika att JAVA låser filen för evigt vid en krasch av programmet
        //läser data från path p och skriver datan till path p2

        Path p = Paths.get("src/BraAttHaKod/readAndWrite/enTextfil.txt");
        Path p2 = Paths.get("src/BraAttHaKod/readAndWrite/enTextfil2.txt");

        //try with resources när man skapar upp objekten inom try-parenteserna
        try (BufferedReader br = Files.newBufferedReader(p);
             BufferedWriter bw = Files.newBufferedWriter(p2)) {

            String temp;

            while ((temp = br.readLine()) != null) {
                bw.write(temp);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        //Annat sätt att skriva till fil med kopplade strömmar
        //Filen skapas med "try with resources och stängs därför automatiskt
        try(PrintWriter ut = new PrintWriter(new BufferedWriter(new FileWriter("src/BraAttHaKod/readAndWrite/enTextfil3.txt")))){
            ut.println("Testskriv rad 1");
            ut.println("Testskriv rad 2");
            ut.println("Testskriv rad 3");
        }catch (Exception e){
            e.printStackTrace();
        }



        //Samma som ovan men lägger till data i slutet av filen istället för att skriva över existerande data
        try(PrintWriter ut = new PrintWriter(new BufferedWriter(new FileWriter("src/BraAttHaKod/readAndWrite/enTextfil3.txt",true)))){
            ut.println("Testskriv rad 4");

        }catch (Exception e){
            e.printStackTrace();
        }





    }

    public static void main(String[] args) {
        WriteToFile wtf = new WriteToFile();
    }
}
