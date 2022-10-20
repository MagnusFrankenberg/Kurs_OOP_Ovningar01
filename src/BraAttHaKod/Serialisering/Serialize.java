package BraAttHaKod.Serialisering;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialize {

    public Serialize() {

        Person p1 = new Person("Sigrun");
        Person p2 = new Person("Kalle Anka");

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("src/sprint2/serialisering/storage.ser"))) {

            oos.writeObject(p1);
            oos.writeObject(p2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        Serialize s = new Serialize();
    }

}



