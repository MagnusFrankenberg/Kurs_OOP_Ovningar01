package Sprint_4.Uppg_10;

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
            Object obj;
            if ((obj = fromSocket.readObject()) instanceof Intro) {
                System.out.println((Intro) obj);
            }

            Object datafromServer;
            String requestToServer;

            while ((requestToServer = fromKeyboard.readLine()) != null) {
                toSocket.println(requestToServer);
                datafromServer = fromSocket.readObject();
                Respons respons = (Respons) datafromServer;

                if (respons.foundPerson) {
                    System.out.println(respons.p);
                } else {
                    System.out.println("Kunde inte hitta någon person med namnet " + requestToServer);
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
