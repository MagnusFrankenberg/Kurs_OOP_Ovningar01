package Sprint_4.Uppg_4a;

import javax.swing.*;
import java.util.*;

public class StartSensors {

    List<Sensor> sensorList = new ArrayList<>();
    List<Thread> myThreads = new ArrayList<>();

    public StartSensors(){
        SQueue queue1 = new SQueue();

        int antalSensorer = Integer.parseInt(JOptionPane.showInputDialog("Ange antal Sensorer"));

        for (int i = 0; i < antalSensorer; i++) {
            String city = JOptionPane.showInputDialog(null,"I vilken Stad mäts temperaturen","Mätställe",3);
            int interval = Integer.parseInt(JOptionPane.showInputDialog(null,"Med vilket intervall ska temperaturen mätas","Mätintervall",3));
            sensorList.add(new Sensor(city,interval,queue1));
        }

        for (int i = 0; i < sensorList.size(); i++) {
            myThreads.add(new Thread(sensorList.get(i)));
        }

        for(Thread t:myThreads){
            t.start();
        }

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Thread t:myThreads){
            t.interrupt();
        }
    }


    public static void main(String[] args) {
        StartSensors st = new StartSensors();
    }

}
