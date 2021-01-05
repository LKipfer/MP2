package Messages;

import java.util.ArrayList;

public class Msg_CreateToDo extends Message{

    @Override
    protected void receiveAttributes(ArrayList<NameValue> attributes) {

    }

    @Override
    protected void sendAttributes(ArrayList<NameValue> attributes) {

    }

    //All commands that work with ToDos...
    //- ...require a valid token (the user must be logged in)
    //- ...only work for ToDos that belong to the current user

    /*
    Data:   Title, Priority, Description, [due Date]
    Notes:  Fails if data is invalid, title too short, date in the past, etc.
            Server replies with the ID

     */
}
