package Messages;

import java.util.ArrayList;

public class Msg_ChangePw extends Message {

    @Override
    protected void receiveAttributes(ArrayList<NameValue> attributes) {

    }

    @Override
    protected void sendAttributes(ArrayList<NameValue> attributes) {

    }

    /*
    Data:   New Password
    Notes:  Fails if new Password is too short or if token is invalid
     */
}
