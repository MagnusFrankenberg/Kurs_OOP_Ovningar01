package BraAttHaKod.TCP.ClientServerSkickarObjekt;

import java.io.*;
import java.net.Socket;

public class Klient {


    public Klient() {

        try (
                Socket socket = new Socket("127.0.0.1", 45678);
                ObjectInputStream fromSocket = new ObjectInputStream(socket.getInputStream());
                PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader fromKeyboard = new BufferedReader(new InputStreamReader(System.in));

        ) {
            String welcomeMessage = (String) fromSocket.readObject();
            System.out.println(welcomeMessage);

            Object datafromServer;
            String requestToServer;

            while ((requestToServer = fromKeyboard.readLine()) != null) {
                toSocket.println(requestToServer);
                datafromServer = fromSocket.readObject();
                if (datafromServer instanceof Person) {
                    Person p = (Person) datafromServer;
                    System.out.println(p);
                } else {
                    String s = (String) datafromServer;
                    System.out.println(s);
                }


            }
        } catch (IOException e) {
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Klient k = new Klient();
    }
}
