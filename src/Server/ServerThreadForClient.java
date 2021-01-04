package Server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerThreadForClient extends Thread {
    private static int clientNumber = 0;
    private final Logger logger = Logger.getLogger("");
    private Socket socket;

    public ServerThreadForClient(Socket socket) {
        super("Client thread" +clientNumber++);
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream());)
        {
            logger.info("Request from client " + socket.getInetAddress().toString() + " for server " + socket.getLocalAddress().toString());

            //Send our reply using HTTP 1.0
            out.print("HTTP/1.0 200m \r\n"); //Version and Status
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
            String outString = received.toString();
            out.print(outString);
            logger.info("Request contents:\n" + outString);

            out.flush();
            socket.close();

        } catch (IOException e)
        {logger.warning(e.toString()); }
    }
}
