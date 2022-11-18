package Sprint_4.Uppg_1_ServerToClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyServer {

    public MyServer() {

        try (ServerSocket serverSocket = new ServerSocket(45678);
             Socket socket = serverSocket.accept();

             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String message = "Här kommer ett meddelande";

            while (true) {
                out.println(message);
                Thread.sleep(3000);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MyServer ms = new MyServer();
    }
}