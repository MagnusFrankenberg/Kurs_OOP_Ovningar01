package Sprint_4.Uppg_4a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SensorSender {

    String sendString;

    public SensorSender(String sendString) throws IOException {
        this.sendString = sendString;

        InetAddress ip = InetAddress.getLocalHost();
        int toPort = 44555;
        DatagramSocket ds = new DatagramSocket();

        byte[] bytes = sendString.getBytes();
        DatagramPacket dgp = new DatagramPacket(bytes, bytes.length, ip, toPort);
        ds.send(dgp);

    }
}




