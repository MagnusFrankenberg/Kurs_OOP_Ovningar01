package BraAttHaKod.Serialisering;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Deserialize {

    public Deserialize(){


        try(ObjectInputStream oos = new ObjectInputStream(
                new FileInputStream("src/sprint2/serialisering/storage.ser"))){

            Object o1 = oos.readObject();
            Object o2 = oos.readObject();

            if (o1 instanceof Person){
                System.out.println(((Person)o1).getName());
            }
            if (o2 instanceof Person){
                System.out.println(((Person)o2).getName());
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String args[] ){
        Deserialize d = new Deserialize();
    }

}
