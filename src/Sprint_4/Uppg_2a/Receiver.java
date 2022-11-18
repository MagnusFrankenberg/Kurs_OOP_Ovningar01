package Sprint_4.Uppg_2a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {

    public Receiver() throws IOException {

        int port = 44555;
        DatagramSocket ds = new DatagramSocket(44555);
        byte[] bytes = new byte[254];

        while (true) {
            DatagramPacket dgp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dgp);
           // System.out.println(dgp.getAddress());
            String s = new String(dgp.getData(), 0, dgp.getLength());
            System.out.println(s);
        }
    }


    public static void main(String[] args) throws IOException{
        Receiver r = new Receiver();
    }
}
