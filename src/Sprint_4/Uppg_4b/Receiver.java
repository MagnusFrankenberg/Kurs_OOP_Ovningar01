package Sprint_4.Uppg_4b;

import java.io.IOException;
import java.net.*;


    public class Receiver {

        ReceiveGUI rgui;

        public Receiver(ReceiveGUI rgui) throws IOException {
            this.rgui = rgui;

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
                rgui.updateTextArea(s);
            }
        }

        public static void main(String[] args) throws  IOException {
            Receiver rec = new Receiver(new ReceiveGUI());

        }
    }


