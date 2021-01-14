package Client;

import Messages.*;

import java.io.IOException;
import java.net.Socket;

public class ClientModel {
    String ipAddress;
    Integer port;

    public void init(String ipAddress, Integer port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    private Socket connect() {
        Socket socket = null;
        try {
            socket = new Socket(ipAddress, port);
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
        return socket;
    }

    public String sayChangePw(String clientName) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Msg_ChangePw msgOut = new Msg_ChangePw();
            msgOut.setClient(clientName);
            msgOut.getUsername();
            msgOut.setPassword("124");
            try {
                msgOut.send(socket);
                Message msgIn = Message.receive(socket);
                result = msgIn.toString();
            } catch (Exception e) {
                result = e.toString();
            }
            try { if (socket != null) socket.close(); } catch (IOException e) {}
        }
        return result;
    }

    public String sayCreateLogin(String clientName) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Msg_CreateLogin msgOut = new Msg_CreateLogin();
            msgOut.setClient(clientName);
            msgOut.setUsername("Jennifer Jumpingjacks");
            msgOut.setPassword("123");
            try {
                msgOut.send(socket);
                Message msgIn = Message.receive(socket);
                result = msgIn.toString();
            } catch (Exception e) {
                result = e.toString();
            }
            try { if (socket != null) socket.close(); } catch (IOException e) {}
        }
        return result;
    }

    public String sayCreateToDo(String clientName) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Message msgOut = new Msg_CreateToDo();
            msgOut.setClient(clientName);
            try {
                msgOut.send(socket);
                Message msgIn = Message.receive(socket);
                result = msgIn.toString();
            } catch (Exception e) {
                result = e.toString();
            }
            try { if (socket != null) socket.close(); } catch (IOException e) {}
        }
        return result;
    }

    public String sayDeleteToDo(String clientName) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Message msgOut = new Msg_DeleteToDo();
            msgOut.setClient(clientName);
            try {
                msgOut.send(socket);
                Message msgIn = Message.receive(socket);
                result = msgIn.toString();
            } catch (Exception e) {
                result = e.toString();
            }
            try { if (socket != null) socket.close(); } catch (IOException e) {}
        }
        return result;
    }

    public String sayGetToDo(String clientName) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Message msgOut = new Msg_GetToDo();
            msgOut.setClient(clientName);
            try {
                msgOut.send(socket);
                Message msgIn = Message.receive(socket);
                result = msgIn.toString();
            } catch (Exception e) {
                result = e.toString();
            }
            try { if (socket != null) socket.close(); } catch (IOException e) {}
        }
        return result;
    }

    public String sayListToDo(String clientName) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Message msgOut = new Msg_ListToDo();
            msgOut.setClient(clientName);
            try {
                msgOut.send(socket);
                Message msgIn = Message.receive(socket);
                result = msgIn.toString();
            } catch (Exception e) {
                result = e.toString();
            }
            try { if (socket != null) socket.close(); } catch (IOException e) {}
        }
        return result;
    }

    public String sayLogin(String clientName) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Message msgOut = new Msg_Login();
            msgOut.setClient(clientName);
            try {
                msgOut.send(socket);
                Message msgIn = Message.receive(socket);
                result = msgIn.toString();
            } catch (Exception e) {
                result = e.toString();
            }
            try { if (socket != null) socket.close(); } catch (IOException e) {}
        }
        return result;
    }

    public String sayLogout(String clientName) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Message msgOut = new Msg_Logout();
            msgOut.setClient(clientName);
            try {
                msgOut.send(socket);
                Message msgIn = Message.receive(socket);
                result = msgIn.toString();
            } catch (Exception e) {
                result = e.toString();
            }
            try { if (socket != null) socket.close(); } catch (IOException e) {}
        }
        return result;
    }

    public String sayPing(String clientName) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Message msgOut = new Msg_Ping();
            msgOut.setClient(clientName);
            try {
                msgOut.send(socket);
                Message msgIn = Message.receive(socket);
                result = msgIn.toString();
            } catch (Exception e) {
                result = e.toString();
            }
            try { if (socket != null) socket.close(); } catch (IOException e) {}
        }
        return result;
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
}
