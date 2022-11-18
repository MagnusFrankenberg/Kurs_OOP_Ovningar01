package BraAttHaKod.TCP.ClientServerMedProtokoll;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {




    public static void main(String[] args) throws IOException {
        int portNumber = 34567;

            try (
                    ServerSocket serverSocket = new ServerSocket(portNumber);
                    Socket socket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {

                String inputLine, outputLine;

                // Initiate conversation with client
                Protokollv2 pk = new Protokollv2();
                outputLine = pk.processInput(null);
                out.println(outputLine);

                while ((inputLine = in.readLine()) != null) {
                    outputLine = pk.processInput(inputLine);
                    out.println(outputLine);
                    if (outputLine.equals("Hej Då"))
                        break;
                }
            } catch (IOException e) {
                System.out.println("Exception caught when trying to listen on port "
                        + portNumber + " or listening for a connection");
                System.out.println(e.getMessage());
            }
        }
    }