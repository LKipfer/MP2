import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.logging.Logger;

public class server extends Thread {

    private Integer port;
    private final Logger logger = Logger.getLogger("");

    @Override
    public void run() {
        try (ServerSocket listener = new ServerSocket(50001,10,null))
        {
         logger.info("Listening on port " + port);

         while (true)
         {
             //Wait for request, then create input/output streams to talk to the client
             try (Socket client = listener.accept(); // our code waits here for a request to arrive
                 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(client.getOutputStream()); )
             {
                 //read and answer request
                 logger.info("Request from client " + client.getInetAddress().toString() + " for server " + client.getLocalAddress().toString());

                 //Send our reply using HTTP 1.0
                 out.print("HTTP/1.0 200 \r\n"); //Version and Status
                 out.print("Content-Type: text/plain\r\n");
                 out.print("\r\n"); //This signalizes the end of the request, so server knows it should start reading

                 //Read request from client and interact accordingly
                 //An empty string (length 0) is the end of an HTTP request
                 StringBuilder received = new StringBuilder();
                 String inString;
                 while ((inString = in.readLine()) != null && inString.length() != 0)
                 {
                     received.append(inString + "\n");
                 }

                 //Send output back
                 //........

                 out.flush();
             }

         }
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
