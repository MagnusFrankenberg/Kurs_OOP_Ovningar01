package BraAttHaKod.TCP.IntroServerToClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {

    public MyClient(){

        try(Socket socket = new Socket("127.0.0.1",45678);
            BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            String temp;
            while ((temp = buf.readLine()) != null) {
                System.out.println(temp);
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MyClient mc = new MyClient();
    }
}
