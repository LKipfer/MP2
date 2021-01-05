package Messages;

import java.util.ArrayList;

public class Msg_CreateLogin extends Message{

    @Override
    protected void receiveAttributes(ArrayList<NameValue> attributes) {

    }

    @Override
    protected void sendAttributes(ArrayList<NameValue> attributes) {

    }

    /*
    Data:   Username, Password
    Notes:  Fails if name already taken, or invalid
            After creating an Account, you still have to login
     */
}
