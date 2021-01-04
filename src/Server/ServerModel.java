package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerModel extends Thread {

    private Integer port;
    private final Logger logger = Logger.getLogger("");

    @Override
    public void run() {
        try (ServerSocket listener = new ServerSocket(50001,10,null))
        {
         logger.info("Listening on port " + port);

         while (true) {
             //Wait for request, then create input/output streams to talk to the client
             Socket socket = listener.accept();
             ServerThreadForClient client = new ServerThreadForClient(socket);
             client.start();
         }
        } catch (Exception e)
        {System.err.println(e); }
    };

    public void setPort(Integer port)
    {this.port = port;}

}
