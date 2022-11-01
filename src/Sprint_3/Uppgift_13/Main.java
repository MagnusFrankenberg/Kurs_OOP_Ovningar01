package Sprint_3.Uppgift_13;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        String medicintyp = JOptionPane.showInputDialog("Ange medicintyp");
        int ggrMin = Integer.parseInt(JOptionPane.showInputDialog("Ange ggr per min"));
        Medicine m1 = new Medicine(medicintyp,ggrMin);

         medicintyp = JOptionPane.showInputDialog("Ange medicintyp");
         ggrMin = Integer.parseInt(JOptionPane.showInputDialog("Ange ggr per min"));
        Medicine m2 = new Medicine(medicintyp,ggrMin);

        medicintyp = JOptionPane.showInputDialog("Ange medicintyp");
        ggrMin = Integer.parseInt(JOptionPane.showInputDialog("Ange ggr per min"));
        Medicine m3 = new Medicine(medicintyp,ggrMin);


        m1.start();
        m2.start();
        m3.start();

        Thread.sleep(10000);

        m1.interrupt();
        m2.interrupt();
        m3.interrupt();
    }
}
