package Sprint_4.Uppg_3_v2;

import java.io.IOException;
import java.net.*;


    public class Receiver {

        ChattGUI gui;

        public Receiver(ChattGUI gui) throws IOException {
            this.gui = gui;

            int port = 12540;
            MulticastSocket socket = new MulticastSocket(port);
            byte[] bytes = new byte[254];
            InetAddress ip = InetAddress.getByName("234.235.236.237");

            InetSocketAddress group = new InetSocketAddress(ip, port);
            NetworkInterface netIf = NetworkInterface.getByName("en0");

            socket.joinGroup(group, netIf);


            while(true){
                DatagramPacket dgp = new DatagramPacket(bytes, bytes.length);
                socket.receive(dgp);
                String s = new String(dgp.getData(), 0, dgp.getLength());
                gui.updateTextArea(s);
            }
        }


    }


