package Sprint_2.Uppgift_12;



import javax.swing.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserializeObjects {

    public List<Fordon> deserialize(String filename) {

        List<Fordon> fordonList = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filename))) {

            Object obj;
            while ((obj = in.readObject()) != null) {
                if (obj instanceof Fordon) {
                    fordonList.add((Fordon) obj);
                }
            }
        }catch (EOFException e){
            System.out.println("Alla objekt har lästs upp till Lista");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fordonList;
    }
}


