package Messages;

import java.util.ArrayList;

public class Msg_DeleteToDo extends Message{

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
    Data:   ID
    Notes:  Fails if the ID does not exist for this user
     */
}
