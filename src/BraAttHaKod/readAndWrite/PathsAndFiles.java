package BraAttHaKod.readAndWrite;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsAndFiles {

    public PathsAndFiles() {

        //Klassen Paths:
        //Skapar upp ett path-objekt där filen heter "enTextfil2.txt" och sökvägen är "src/BraAttHaKod/readAndWrite/"
        //Detta betyder INTE att den filen faktiskt behöver existera i filsystemet.
        Path p = Paths.get("src/BraAttHaKod/readAndWrite/enTextfil2.txt");

        //KLassen Files:
        //skapa en fil i filsystemet med Files.createFile(Path path)
        //Kolla först att filen inte redan existerar
        try {
            if(!Files.exists(p)) {
                Files.createFile(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Kopiera filer från source to target:
   // Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING)

    //Flytta fil och skriv över eventuell tidigare fil:
    //Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING)

    //Ta bort en fil
    //Files.delete(Path path)








        public static void main (String[]args){
            PathsAndFiles paf = new PathsAndFiles();
        }
    }

