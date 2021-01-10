package Server;


import Messages.*;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerThreadForClient extends Thread {
    private final Logger logger = Logger.getLogger("");
    private Socket clientSocket;


    public ServerThreadForClient(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    //Process messages until Client says "Goodbye"

    @Override
    public void run() {
        logger.info("Request from client " + clientSocket.getInetAddress().toString() + " for server " + clientSocket.getLocalAddress().toString());


        try {
            // Read a message from the client
            Message msgIn = Message.receive(clientSocket);
            Message msgOut = processMessage(msgIn);
            msgOut.send(clientSocket);
            logger.info("Answered with: " + msgOut.toString());
        } catch (Exception e) {
            logger.severe(e.toString());
        } finally {
            try { if (clientSocket != null) clientSocket.close(); } catch (IOException e) {}
        }

    }

    private Message processMessage(Message msgIn) {
        logger.info("Message received from client: "+ msgIn.toString());
        //String clientName = msgIn.getClient();

        Message msgOut = null;
        switch (MessageType.getType(msgIn)) {
            case ChangePw:
                msgOut = new Msg_Result();
                break;
            case CreateLogin:   //probably wrong
                Msg_CreateLogin newLogin_msg = (Msg_CreateLogin) msgIn;
                Msg_Result nla_msg = new Msg_Result();
                msgOut = nla_msg;
                break;
            case CreateToDo:
                msgOut = new Msg_Result();
                break;
            case DeleteToDo:
                msgOut = new Msg_Result();
                break;
            case GetToDo:
                msgOut = new Msg_Result();
                break;
            case Goodbye:
                msgOut = new Msg_Result();
                break;
            case ListToDo:
                msgOut = new Msg_Result();
                break;
            case Login:
                msgOut = new Msg_Result();
                break;
            case Logout:
                msgOut = new Msg_Result();
                break;
            case Ping:
                msgOut = new Msg_Result();
                break;
            default:
                msgOut = new Msg_Result();
        }
        //msgOut.setClient(clientName);
        return msgOut;
    }

}
