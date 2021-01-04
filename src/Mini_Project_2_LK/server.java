package Mini_Project_2_LK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class server {

    public static void main(String[] args){
        //All of this would be placed inside the run method of a thread, instead of the main method.
        try (ServerSocket listener = new ServerSocket(50001,10,null);)
        {
          //while (true) { }
            try (Socket socket = listener.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());)
            {
                String message = in.readLine();
                System.out.println("Received: " + message);
                out.write("Hello from the Server\r\n");
                out.flush();
                System.out.println("Replied to Client");
            }
            catch (Exception e)
            {System.out.println(e.toString()); }
        }
        catch (Exception e)
        {System.out.println(e.toString()); } ;

    }
}
