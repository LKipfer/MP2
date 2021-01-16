package Messages;

import java.util.ArrayList;

//THIS IS THE ONLY MESSAGE THAT THE SERVER WILL USE TO ANSWER

public class Msg_Result extends Message {
    private static final String ELEMENT_USERNAME = "username";

    private String username;


    public Msg_Result() {
        super();
    }

    @Override
    protected void receiveAttributes(ArrayList<NameValue> pairs) {
        this.username = findAttribute(pairs, ELEMENT_USERNAME);

    }

    @Override
    protected void sendAttributes(ArrayList<NameValue> pairs) {
        pairs.add(new NameValue(ELEMENT_USERNAME, this.username));

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
