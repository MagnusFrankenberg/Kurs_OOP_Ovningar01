package Sprint_4.Uppg_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Klient {

    public static void main(String[] args) throws IOException {

        try (
                Socket socket = new Socket("127.0.0.1", 34567);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
        ) {
            System.out.println(socketIn.readLine());
            String userInput;
            while ((userInput = userIn.readLine()) != null) {
                out.println(userInput);
                String fromSocket = socketIn.readLine();
                System.out.println(fromSocket);
                if (fromSocket.equalsIgnoreCase("hej då")) {
                    System.exit(0);
                }
            }
        }
    }
}


