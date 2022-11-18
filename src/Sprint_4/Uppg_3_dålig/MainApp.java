package Sprint_4.Uppg_3_dålig;

import java.io.IOException;

public class MainApp {


    public MainApp() throws IOException {
        MultiSender sender = new MultiSender();
        GUI gui = new GUI();
        MultiReceiver mr = new MultiReceiver(gui);

    }




    public static void main(String[] args) throws IOException {
        MainApp ma = new MainApp();
    }
}
