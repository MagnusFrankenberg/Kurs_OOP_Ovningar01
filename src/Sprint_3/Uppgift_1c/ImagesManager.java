package Sprint_3.Uppgift_1c;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ImagesManager {

    List<Path> bilder = new ArrayList<>();

    public ImagesManager() {
        Path dirName = Paths.get("/Users/magnusfrankenberg/Desktop/BilderTillJavaTräning");

        try (var inStream = Files.newDirectoryStream(dirName, "*.jpg")) {

            for (Path path : inStream) {
                bilder.add(path);
            }
            //   inStream.forEach(path -> bilder.add(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


