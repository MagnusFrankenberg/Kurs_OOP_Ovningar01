package Sprint_4.Uppg_3_v2_Threads;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Sender implements ActionListener {

    ChattGUI cGUI;
    String namn;

    String message;

    public Sender() throws IOException{
        namn = JOptionPane.showInputDialog("Ange namn");
        cGUI = new ChattGUI(namn, this);
        Thread receiverThread = new Thread(new Receiver(cGUI));
        receiverThread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cGUI.button) {
            System.exit(0);
        }

        if(e.getSource()== cGUI.textField){
            message = namn+": "+ cGUI.textField.getText();
            try {
                stringSender(message);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            cGUI.textField.setText("");
        }
    }

    public void stringSender(String mess) throws IOException {

        InetAddress ip = InetAddress.getByName("234.235.236.237");
        int toPort = 12540;
        MulticastSocket socket = new MulticastSocket();

        byte[] bytes = mess.getBytes();
        DatagramPacket dgp = new DatagramPacket(bytes, bytes.length, ip, toPort);
        socket.send(dgp);
    }


    public static void main(String[] args) throws IOException {
        Sender sender = new Sender();

    }


}
