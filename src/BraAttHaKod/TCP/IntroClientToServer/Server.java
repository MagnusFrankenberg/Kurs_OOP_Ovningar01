package BraAttHaKod.TCP.IntroClientToServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //Detta är ett enkelt program där Klient skickar strängen "meddelande" till Server med 2 sek intervall.
    public Server(){

        try(ServerSocket s = new ServerSocket(44444);
            Socket sock = s.accept();
            BufferedReader buf = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        ){

            String temp;
            while((temp = buf.readLine()) != null){
                System.out.println(temp);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        Server s = new Server();
    }
}