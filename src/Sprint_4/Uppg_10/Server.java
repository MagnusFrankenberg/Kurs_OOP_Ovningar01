package Sprint_4.Uppg_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {


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
