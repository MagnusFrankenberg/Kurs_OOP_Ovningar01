package BraAttHaKod.TCP.MultiClientServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverlistener {

    //Servern är uppdelad i klasserna Server och Serverlistener.
    //Uppstarten av socket är utflyttad till Serverlistener
    //Serverlistener ligger och lyssnar efter nya klienter, vid accept så..
    //..startas ett nytt Server-objekt upp där en socket skickas med till konstruktorn i Serverklassen
    //en ny tråd av Servern startas upp
    //Serverklassen extends Thread och körs i flera trådar
    //Se till att Klientklassen får köras i multiple instances i övrigt ser Klientklassen oförändrad ut

    public Serverlistener() {

        try (ServerSocket ss = new ServerSocket(45678);) {
            while (true) {
                Socket socket = ss.accept();
                Server server = new Server(socket);
                server.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Serverlistener sl = new Serverlistener();
    }
}
