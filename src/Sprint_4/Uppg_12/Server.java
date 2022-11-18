package Sprint_4.Uppg_12;

import java.io.*;
import java.net.Socket;

public class Server extends Thread {

    private Socket socket;
    private Multiwriter multiwriter;


    public Server(Socket socket, Multiwriter multiwriter) {
        this.socket = socket;
        this.multiwriter = multiwriter;
    }

    public void run() {

        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {

          //  Lägger in vår printwriter i multiwriters lista
            multiwriter.addWriter(out);


            while (true) {
                String stringFromClient = in.readLine();
                if (stringFromClient == null) {
                    return;
                }

                for (PrintWriter writer : multiwriter.getWriters()) {
                    writer.println(stringFromClient);
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
