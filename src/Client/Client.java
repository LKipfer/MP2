package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
     try  (  Socket socket = new Socket("localhost",50001);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());)
     {
         //GET etc.
         //Remember \r\n because it marks the end of a line.
         //At the very end of the HTTP request we have to use \r\n\r\n as it ends the http request.
         out.write("Hello from Client!\r\n");
         out.flush();
         String message = in.readLine();
         System.out.println("Server said: " + message);
     }
     catch (Exception e)
     {System.out.println(e.toString()); }


    }

}
