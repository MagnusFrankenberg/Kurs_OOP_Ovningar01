package Sprint_4.Uppg_12;

import Sprint_4.Uppg_10.Intro;
import Sprint_4.Uppg_10.Respons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Klient implements ActionListener {

    ChattGUI chattGUI;
    String message;
    BufferedReader fromSocket;
    PrintWriter toSocket;


    public Klient() throws IOException {

        chattGUI = new ChattGUI(this);

        try {
            Socket socket = new Socket("127.0.0.1", 45678);
            toSocket = new PrintWriter(socket.getOutputStream(), true);
            fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String fromServer;

            while ((fromServer = fromSocket.readLine()) != null) {
                chattGUI.updateTextArea(fromServer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Override
        public void actionPerformed (ActionEvent e) {

            if (e.getSource() == chattGUI.button) {
                System.exit(0);
            }
            if (e.getSource() == chattGUI.textField) {
                try {
                    message = chattGUI.namn + ": " + chattGUI.textField.getText();
                    toSocket.println(message);
                    chattGUI.textField.setText("");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    public static void main(String[] args) throws IOException{
        Klient k = new Klient();
    }


}
