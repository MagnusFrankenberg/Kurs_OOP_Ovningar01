package Sprint_4.Uppg_2a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Sender {


    public Sender() throws IOException {

       // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  //skriv om senare
        InetAddress ip = InetAddress.getLocalHost();
        int toPort = 44555;
        DatagramSocket ds = new DatagramSocket();
    //    String myString;

        /*
        while ((myString = in.readLine()) != null) {
            byte[] bytes = myString.getBytes();
            DatagramPacket dgp = new DatagramPacket(bytes, bytes.length, ip, toPort);
            ds.send(dgp);
         */
            Quotes quotes = new Quotes();
            for (String s : quotes.quotelist) {
                byte[] bytes = s.getBytes();
                DatagramPacket dgp = new DatagramPacket(bytes,bytes.length,ip,toPort);
                ds.send(dgp);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Ett exception hände");
                }
            }
        }

    public static void main(String[] args) throws IOException {
        Sender s = new Sender();
    }
}
