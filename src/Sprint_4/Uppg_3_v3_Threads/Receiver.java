package Sprint_4.Uppg_3_v3_Threads;

import java.io.IOException;
import java.net.*;


    public class Receiver implements Runnable {

        ChattGUI gui;

        public Receiver(ChattGUI gui) throws IOException {
           this.gui = gui;
        }

        @Override
        public void run() {
            try {
                int port = 12540;
                MulticastSocket socket = new MulticastSocket(port);
                InetAddress ip = InetAddress.getByName("234.235.236.237");
                InetSocketAddress group = new InetSocketAddress(ip, port);
                NetworkInterface netIf = NetworkInterface.getByName("en0");
                socket.joinGroup(group, netIf);
                byte[] bytes = new byte[254];
                while (true) {
                    DatagramPacket dgp = new DatagramPacket(bytes, bytes.length);
                    socket.receive(dgp);
                    String s = new String(dgp.getData(), 0, dgp.getLength());
                    gui.updateTextArea(s);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


