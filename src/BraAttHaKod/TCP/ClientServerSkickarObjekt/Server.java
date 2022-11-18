package BraAttHaKod.TCP.ClientServerSkickarObjekt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    databas db = new databas();

    public Server() {

        try (
                ServerSocket ss = new ServerSocket(45678);
                Socket socket = ss.accept();
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            out.writeObject("Välkommen, Ange namn på personen du vill ha uppgifter om");

            Object fromServer = null;
            String requestFromClient = "";
            while ((requestFromClient = in.readLine()) != null) {
                fromServer = db.getPerson(requestFromClient.trim());
                if (fromServer instanceof Person)
                    out.writeObject(fromServer);
                else
                    out.writeObject("Kunde inte hitta en person med namnet " + requestFromClient);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Server s = new Server();
    }

}
