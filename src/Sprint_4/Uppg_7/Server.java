package Sprint_4.Uppg_7;

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

            out.writeObject(new Intro());

            Person person = null;
            String requestFromClient = "";
            while ((requestFromClient = in.readLine()) != null) {
                if((person = db.getPerson(requestFromClient.trim()))!=null){
                    out.writeObject(new Respons(person,true));
                } else {
                    out.writeObject(new Respons(null, false));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Server s = new Server();
    }

}
