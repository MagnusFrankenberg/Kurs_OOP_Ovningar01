package Sprint_2.Uppgift_12;



import javax.swing.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializeObjects {

    public void serialize(List<Fordon> fordonsList, String filename) {

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename))) {

            for(Fordon f:fordonsList)
            out.writeObject(f);
            JOptionPane.showMessageDialog(null, "Dina Fordon har sparats ner i "+filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
