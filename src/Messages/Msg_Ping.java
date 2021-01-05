package Messages;

import java.util.ArrayList;

public class Msg_Ping extends Message {
    @Override
    protected void receiveAttributes(ArrayList<NameValue> attributes) {

    }

    @Override
    protected void sendAttributes(ArrayList<NameValue> attributes) {

    }

    /*
    Data:   [Token]
    Notes:  Without token: always succeeds
            With token: succeeds only if token is valid
     */
}
