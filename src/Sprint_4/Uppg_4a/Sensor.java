package Sprint_4.Uppg_4a;

import java.io.IOException;
import java.util.Scanner;

public class Sensor implements Runnable {

  String city;
  double temp;

  int interval;
  SQueue queue;


    public Sensor(String city, int interval, SQueue queue){
        this.city = city;
        this.interval = interval;
        this.queue = queue;
    }

    public String takeNewTemperature() {
        String cityTemp = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ange temperatur i " + city + ": ");
        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                temp = sc.nextDouble();
                break;
            } else {
                System.out.println("Fel format på input, försök igen");
                sc.nextLine();
            }
        }
        cityTemp = String.join(",", city, String.valueOf(temp));
        return cityTemp;


    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
               new SensorSender(takeNewTemperature());
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                break;
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
