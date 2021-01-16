package Server;

import Messages.*;

import java.io.*;
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
        Msg_Result result_msg = new Msg_Result();
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
                Msg_ChangePw changepw_msg = (Msg_ChangePw) msgIn;
                result_msg.setUsername(changepw_msg.getUsername());
                result_msg.setPassword(changepw_msg.getPassword());
                msgOut = result_msg;
                break;
            case CreateLogin:
                Msg_CreateLogin crlogin_msg = (Msg_CreateLogin) msgIn;
                result_msg.setUsername(crlogin_msg.getUsername());
                result_msg.setPassword(crlogin_msg.getPassword());
                msgOut = result_msg;
                break;
            case CreateToDo:
                Msg_CreateToDo create_msg = (Msg_CreateToDo) msgIn;
                result_msg.setTitle(create_msg.getTitle());
                result_msg.setPriority(create_msg.getPriority());
                result_msg.setDescription(create_msg.getDescription());
                msgOut = result_msg;
                break;
            case DeleteToDo:
                Msg_DeleteToDo del_msg = (Msg_DeleteToDo) msgIn;
                result_msg.setTitle(del_msg.getTitle());
                result_msg.setPriority(del_msg.getPriority());
                result_msg.setDescription(del_msg.getDescription());
                msgOut = result_msg;
                break;
            case GetToDo:
                Msg_GetToDo get_msg = (Msg_GetToDo) msgIn;
                result_msg.setTitle(get_msg.getTitle());
                result_msg.setPriority(get_msg.getPriority());
                result_msg.setDescription(get_msg.getDescription());
                msgOut = result_msg;
                break;
            case Goodbye:
			    msgOut = new Msg_Goodbye();
			    break;
            case ListToDo:
                Msg_ListToDo list_msg = (Msg_ListToDo) msgIn;
                result_msg.setTitle(list_msg.getTitle());
                result_msg.setPriority(list_msg.getPriority());
                result_msg.setDescription(list_msg.getDescription());
                msgOut = result_msg;
                break;
            case Login:
                Msg_Login login_msg = (Msg_Login) msgIn;
                result_msg.setUsername(login_msg.getUsername());
                result_msg.setPassword(login_msg.getPassword());
                msgOut = result_msg;
                //System.out.println("msgOut isch: " + msgOut);
                break;
            case Logout:
                Msg_Logout logout_msg = (Msg_Logout) msgIn;
                result_msg.setUsername(logout_msg.getUsername());
                result_msg.setPassword(logout_msg.getPassword());
                msgOut = result_msg;
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

    public static void mailChecker(String mail){
        boolean valid = true;
        String atsign = "(.*[@].*)";
        if(atsign.matches(mail)){
            System.out.println("You must use a mail-address to sign in");
            valid = false;
        }
    }

    /*  SAVE TO FILE
    Only Todo entries and account infos

    private void SaveToFile()
    {
        FileWriter fw;

        try{
            fw = new FileWriter(new File("geo-savefile.txt"));

            for (var item:tvCountry.getItems()
            ) {
                fw.write(String.format("%s-%s-%s-%s-%s-%s", item.getId(), item.getName(), etc.);
                fw.write(System.lineSeparator());
            }

            fw.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
     */

    /* READ FROM FILE (also wait till done)
    private String[] ReadFromFile()
    {
        BufferedReader br;
        String[] lineList;

        try{
            br = new BufferedReader(new FileReader("geo-savefile.txt"));

            int lines = 0;
            while (br.readLine() != null) {
                lines++;
            }

            br = new BufferedReader(new FileReader("geo-savefile.txt"));
            lineList = new String[lines];
            int i = 0;
            while (i < lines)
            {
                lineList[i] = br.readLine();
                i++;
            }

            return lineList;
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

     */

}
