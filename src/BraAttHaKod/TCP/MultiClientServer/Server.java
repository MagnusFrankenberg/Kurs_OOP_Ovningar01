package BraAttHaKod.TCP.MultiClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Server extends Thread {

    //Servern är uppdelad i klasserna Server och Serverlistener.
    //Uppstarten av socket är utflyttad till Serverlistener
    //Serverlistener ligger och lyssnar efter nya klienter, vid accept så..
    //..startas ett nytt Server-objekt upp där en socket skickas med till konstruktorn i Serverklassen
    //en ny tråd av Servern startas upp
    //Serverklassen extends Thread och körs i flera trådar
    //Se till att Klientklassen får köras i multiple instances i övrigt ser Klientklassen oförändrad ut

    Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try (
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {

            Protokoll pk = new Protokoll();

            out.writeObject(pk.getOutput(null));

            String requestFromClient = "";
            while ((requestFromClient = in.readLine()) != null) {

                out.writeObject(pk.getOutput(requestFromClient));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
