package Messages;

import java.util.ArrayList;

public class Msg_Login extends Message{

    @Override
    protected void receiveAttributes(ArrayList<NameValue> attributes) {

    }

    @Override
    protected void sendAttributes(ArrayList<NameValue> attributes) {

    }

    /*
    Data:   Username, Password
    Notes:  Fails if name/password do not match
     */
}
