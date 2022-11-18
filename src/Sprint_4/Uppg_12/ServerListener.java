package Sprint_4.Uppg_12;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerListener {

    private static Multiwriter multiwriter = new Multiwriter();

    public static void main(String[] args) throws IOException {

        while (true) {
            try (ServerSocket ss = new ServerSocket(45678);) {
                final Socket socket = ss.accept();
                Server server = new Server(socket, multiwriter);
                server.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
