package Sprint_4.Uppg_3_v3_Threads;

import javax.swing.*;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException{
        String namn = JOptionPane.showInputDialog("Ange namn");
        Sender mySender = new Sender(namn);
        Receiver myReciever = new Receiver(mySender.cGUI);


       Thread receiverThread = new Thread(myReciever);
       receiverThread.start();

    }
}

