package Sprint_4.Uppg_3_dålig;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiSender{

    InetAddress ip;
    int toPort;
    MulticastSocket socket;

    public MultiSender() throws IOException {
    }

    public void sendString(String s) throws IOException {
        ip = InetAddress.getByName("234.235.236.237");
        toPort = 12540;
        socket = new MulticastSocket();
        while (s != null) {
            byte[] bytes = s.getBytes();
            DatagramPacket dgp = new DatagramPacket(bytes, bytes.length, ip, toPort);
            socket.send(dgp);
        }
    }


   
}

