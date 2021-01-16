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

    /**
     * Process messages until the client says "Goodbye"
     */
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
        // String clientName = msgIn.getClient();

        Message msgOut = null;
        switch (MessageType.getType(msgIn)) {
            /*

            Example for: NewCustomer
            Message_NewCustomer nc_msg = (Message_NewCustomer) msgIn;
            Message_NewCustomerAccepted nca_msg = new Message_NewCustomerAccepted();
			nca_msg.setName(nc_msg.getName());
			msgOut = nca_msg;

			_________________________________________________________________________

			OLD STUFF: (Server will only answer with message result)

            */
            case ChangePw:
                Msg_ChangePw cp_msg = (Msg_ChangePw) msgIn;
                msgOut = new Msg_ChangePw();
                break;
            case CreateLogin:
                msgOut = new Msg_CreateLogin();
                break;
            case CreateToDo:
                msgOut = new Msg_CreateToDo();
                break;
            case DeleteToDo:
                msgOut = new Msg_DeleteToDo();
                break;
            case GetToDo:
                msgOut = new Msg_GetToDo();
                break;
            case Goodbye:
			    msgOut = new Msg_Goodbye();
			    break;
            case ListToDo:
                msgOut = new Msg_ListToDo();
                break;
            case Login:
                Msg_Login login_msg = (Msg_Login) msgIn;
                Msg_Result result_msg = new Msg_Result();
                result_msg.setUsername(login_msg.getUsername());
                msgOut = result_msg;
                //System.out.println("msgOut isch: " + msgOut);
                break;
            case Logout:
                msgOut = new Msg_Logout();
                break;
            case Ping:
                msgOut = new Msg_Ping();
                break;


            default:
                msgOut = new Msg_Error();
        }

        return msgOut;
    }

    public static void passwordCheck(String password){
        boolean valid = true;
        if(password.length() < 3){
            System.out.println("Password is not three characters long.");
            valid = false;
        }
        if(password.length() > 20){
            System.out.println("Password is too long.");
            valid = false;
        }
        String upperCase = "(.*[A-Z].*)";
        if(!password.matches(upperCase)){
            System.out.println("Password must contain at least one capital letter.");
            valid = false;
        }
        String numbers = "(.*[0-9].*)";
        if(!password.matches(numbers)){
            System.out.println("Password must contain at least one number.");
            valid = false;
        }

        String space = "(.*[   ].*)";
        if(password.matches(space)){
            System.out.println("Password cannot contain a space.");
            valid = false;
        }

        if(valid){
            System.out.println("Password is valid.");
        }

    }

    public static void titleCheck(String title){
        boolean valid = true;
        if(title.length() < 3){
            System.out.println("Title is too short.");
            valid = false;
        }
        if(title.length() > 20) {
            System.out.println("Title is too long.");
            valid = false;
        }

    }

    public static void descriptionCheck(String description){
        boolean valid = true;

        if(description.length() > 256) {
            System.out.println("Description is too long.");
            valid = false;
        }

    }

}
