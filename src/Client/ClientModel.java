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

    public String sayChangePw(String username, String password) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Msg_ChangePw msgOut = new Msg_ChangePw();
            msgOut.setUsername(username);
            msgOut.setPassword(password);
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

    public String sayCreateLogin(String username, String password) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Msg_CreateLogin msgOut = new Msg_CreateLogin();
            msgOut.setUsername(username);
            msgOut.setPassword(password);
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

    public String sayCreateToDo(String title, String priority, String description) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Msg_CreateToDo msgOut = new Msg_CreateToDo();
            msgOut.setTitle(title);
            msgOut.setPriority(priority);
            msgOut.setDescription(description);

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

    public String sayDeleteToDo(String title, String priority, String description){
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Msg_DeleteToDo msgOut = new Msg_DeleteToDo();
            msgOut.setTitle(title);
            msgOut.setPriority(priority);
            msgOut.setDescription(description);

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

    public String sayGetToDo(String title, String priority, String description) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Msg_GetToDo msgOut = new Msg_GetToDo();
            msgOut.setTitle(title);
            msgOut.setPriority(priority);
            msgOut.setDescription(description);

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

    public String sayListToDo(String title, String priority, String description) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Msg_ListToDo msgOut = new Msg_ListToDo();
            msgOut.setTitle(title);
            msgOut.setPriority(priority);
            msgOut.setDescription(description);

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

    public String sayLogin(String username, String password) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Msg_Login msgOut = new Msg_Login();
            msgOut.setUsername(username);
            msgOut.setPassword(password);
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

    public String sayLogout(String username, String password) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Msg_Logout msgOut = new Msg_Logout();
            msgOut.setUsername(username);
            msgOut.setPassword(password);
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
            //msgOut.setClient(clientName);
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

    public String sayGoodbye(String clientName) {
        String result = null;
        Socket socket = connect();
        if (socket != null) {
            Message msgOut = new Msg_Goodbye();
            //msgOut.setClient(clientName);
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


}
