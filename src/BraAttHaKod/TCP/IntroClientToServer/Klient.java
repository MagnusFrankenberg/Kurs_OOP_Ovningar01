package BraAttHaKod.TCP.IntroClientToServer;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//Detta är ett enkelt program där Klient skickar strängen "meddelande" till Server med 2 sek intervall.

public class Klient {

    public Klient(){

        try(Socket sock = new Socket("127.0.0.1", 44444);
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
        ){

            String mess = "meddelande";

            while(true){
                out.println(mess);
                Thread.sleep(2000);
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
        Klient k = new Klient();
    }
}