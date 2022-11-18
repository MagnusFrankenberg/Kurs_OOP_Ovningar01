package Sprint_4.Uppg_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {



    public Server() {

        try (
                ServerSocket ss = new ServerSocket(45678);
                Socket socket = ss.accept();
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
    public static void main(String[] args) {
        Server s = new Server();
    }

}
