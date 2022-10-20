package BraAttHaKod.Serialisering;

import java.io.*;

public class SerializeAndDeserializeMethods {


    //Serialisera (OBS här ej med try-with-resources, därav .close())
    public static void sparaObjekt(Object obj, String filnamn) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filnamn));
            out.writeObject(obj);
            out.close();
        } catch (IOException ie) {
            ie.printStackTrace();
            System.exit(1);
        }
    }


    //Deserialisering (OBS här ej med try-with-resources, därav .close())
    public static Object läsInObjekt(String filnamn) {
        Object obj = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filnamn));
            obj = in.readObject();
            in.close();
        }catch (IOException ie){
            ie.printStackTrace(); System.exit(1);
        }catch (ClassNotFoundException ce){
            ce.printStackTrace();System.exit(2);
        }
        return obj;
    }

}