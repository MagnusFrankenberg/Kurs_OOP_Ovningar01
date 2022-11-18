package Sprint_4.Uppg_1_ClientToServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {

    public MyClient(){

        try(Socket socket = new Socket("127.0.0.1",45678);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true)
        ){
            String message = "Här kommer ett meddelande";

            while (true){
                out.println(message);
                Thread.sleep(3000);
            }
        }catch(UnknownHostException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        MyClient mc = new MyClient();
    }
}
