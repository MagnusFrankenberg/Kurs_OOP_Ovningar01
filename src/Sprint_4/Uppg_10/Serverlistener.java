package Sprint_4.Uppg_10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverlistener {

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
