package BraAttHaKod.readAndWrite;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadDemo {

    public FileReadDemo() {


        //nedan läser hela reder från en fil (readLine)
        //fortsätter till ingen mer rad (=null)
        //BufferedReader buffrar inströmmen (från Filereader) från chars till hela rader (readLine)
        //try with resources används här (skapar objekten i try-parenteserna)

        String temp;

        try (BufferedReader buf = new BufferedReader(new FileReader("src/BraAttHaKod/readAndWrite/enTextfil.txt"))) {
            while ((temp = buf.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //använder man istället endast Filereader kommer man läsa strömmen en char åt gången.
        //Dessa chars tas in i typen int, vill man kan man casta dessa till char (char)   System.out.println((char)temp2)

        int temp2;

        try (FileReader fr = new FileReader("src/BraAttHaKod/readAndWrite/enTextfil.txt")) {
            while ((temp2 = fr.read()) != -1) {
                System.out.println((char) temp2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




        ///Här ett annat mer risky sätt där man stänger filen manuellt (in.close())
        //Om programmet kraschar innan close() kan filen dock förbli låst för vidare användning.
        //1. Skapa upp reader-objekten
        String temp3;
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/BraAttHaKod/readAndWrite/enTextfil.txt"));
            // 2. Arbeta med filen
            while ((temp3 = in.readLine()) != null) {
                System.out.println(temp3);
            }
            // 3. Stäng filen
            in.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }


    public static void main(String[] args) {
        FileReadDemo frd = new FileReadDemo();
    }
}
