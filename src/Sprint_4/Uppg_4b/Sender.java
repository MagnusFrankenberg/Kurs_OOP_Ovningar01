package Sprint_4.Uppg_4b;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class Sender implements ActionListener {

    SenderGUI sGUI;
    String city;
    double temp;
    String reportString;

    public Sender() {
        city = JOptionPane.showInputDialog("Ange Stad");
        sGUI = new SenderGUI(city, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sGUI.button) {
            Scanner sc = new Scanner(sGUI.textField.getText());
            while (sc.hasNext()) {
                if (sc.hasNextDouble()) {
                    temp = sc.nextDouble();
                    break;
                } else {
                    JOptionPane.showInputDialog("Fel format på input, försök igen");
                    sc.nextLine();
                }
            }
            reportString = city + "," + temp;
            try {
                stringSender(reportString);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            sGUI.textField.setText("");
        }
    }

    public void stringSender(String message) throws IOException {

        InetAddress ip = InetAddress.getByName("234.235.236.237");
        int toPort = 12540;
        MulticastSocket socket = new MulticastSocket();

        byte[] bytes = message.getBytes();
        DatagramPacket dgp = new DatagramPacket(bytes, bytes.length, ip, toPort);
        socket.send(dgp);
    }


    public static void main(String[] args) throws IOException {
        Sender sender = new Sender();
    }


}
