package Sprint_4.Uppg_3_dålig;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

import javax.swing.*;

public class MultiReceiver {

    GUI gui;


    public MultiReceiver(GUI gui) throws SocketException, IOException {
        this.gui = gui;
        int port = 12540;
        MulticastSocket socket = new MulticastSocket(port);
        byte[] bytes = new byte[254];
        InetAddress ip = InetAddress.getByName("234.235.236.237");

        InetSocketAddress group = new InetSocketAddress(ip, port);
        NetworkInterface netIf = NetworkInterface.getByName("en0");

        socket.joinGroup(group, netIf);

        while (true) {
            DatagramPacket dgp = new DatagramPacket(bytes, bytes.length);
            socket.receive(dgp);
            String s = new String(dgp.getData(), 0, dgp.getLength());
            updateTextArea(s);
        }

    }

    public void updateTextArea(String s){
        Scanner sc = new Scanner(s);
        JTextArea tArea = gui.textArea;
        String hist = tArea.getText();
        while(sc.hasNext()){
            tArea.setText(hist+sc.nextLine());
        }
    }

}