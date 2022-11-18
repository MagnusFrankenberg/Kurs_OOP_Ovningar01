package Sprint_4.Uppg_5a;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    databas db = new databas();

    public Server() {

        try (
                ServerSocket ss = new ServerSocket(45678);
                Socket socket = ss.accept();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            out.println("Välkommen, Ange namn på personen du vill ha uppgifter om");

            String fromServer = "";
            String requestFromClient = "";
            while ((requestFromClient = in.readLine()) != null) {
                fromServer = db.getPerson(requestFromClient);
                out.println(fromServer);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
    }

}
