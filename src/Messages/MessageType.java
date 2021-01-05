package Messages;

import java.util.List;

/**
 * This class defines all available message types. We provide static functions
 * to map between the types and the value of the enumeration.
 */
public enum MessageType {
    ChangePw,
    CreateLogin,
    CreateToDo,
    DeleteToDo,
    GetToDo,
    ListToDo,
    Login,
    Logout,
    Ping,
    Error;

    public static MessageType parseType(String typeName) {
        MessageType type = MessageType.Error;
        for (MessageType value : MessageType.values()) {
            if (value.toString().equals(typeName)) type = value;
        }
        return type;
    }

    /**
     * Determine the message type from the actual class of this object
     */
    public static MessageType getType(Message msg) {
        MessageType type = MessageType.Error;
        if (msg instanceof Msg_ChangePw) type = ChangePw;
        else if (msg instanceof Msg_CreateLogin) type = CreateLogin;
        else if (msg instanceof Msg_CreateToDo) type = CreateToDo;
        else if (msg instanceof Msg_DeleteToDo) type = DeleteToDo;
        else if (msg instanceof Msg_GetToDo) type = GetToDo;
        else if (msg instanceof Msg_ListToDo) type = ListToDo;
        else if (msg instanceof Msg_Login) type = Login;
        else if (msg instanceof Msg_Logout) type = Logout;
        else if (msg instanceof Msg_Ping) type = Ping;
        return type;
    }

}
