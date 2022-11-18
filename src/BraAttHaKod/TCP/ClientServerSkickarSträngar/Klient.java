package BraAttHaKod.TCP.ClientServerSkickarSträngar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Klient {


    public Klient(){

        try(
        Socket socket = new Socket("127.0.0.1",45678);
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader fromKeyboard = new BufferedReader(new InputStreamReader(System.in));

        ){
            String welcomeMessage = fromSocket.readLine();
            System.out.println(welcomeMessage);

            String datafromServer;
            String requestToServer;

            while ((requestToServer=fromKeyboard.readLine())!=null){
                toSocket.println(requestToServer);
                datafromServer=fromSocket.readLine();
                System.out.println(datafromServer);
            }
        }catch(IOException e){
            throw new RuntimeException();
        }
    }


    public static void main(String[] args) {
        Klient k = new Klient();
    }
}
