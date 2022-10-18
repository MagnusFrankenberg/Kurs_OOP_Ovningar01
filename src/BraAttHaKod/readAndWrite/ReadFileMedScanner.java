package BraAttHaKod.readAndWrite;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFileMedScanner {


    public ReadFileMedScanner(){

        Path p = Paths.get("src/BraAttHaKod/readAndWrite/enTextfil2.txt");
        try{
            Scanner in = new Scanner(p);
            while(in.hasNextLine()){
                System.out.println(in.nextLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



















    public static void main(String[] args) {
        ReadFileMedScanner r = new ReadFileMedScanner();
    }
}
