package Sprint_4.Uppg_1_ClientToServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public MyServer(){

    try(ServerSocket serverSocket = new ServerSocket(45678);
    Socket socket = serverSocket.accept();
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
        MyServer ms = new MyServer();
    }
}