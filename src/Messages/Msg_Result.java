package Messages;

import java.util.ArrayList;

//THIS IS THE ONLY MESSAGE THAT THE SERVER WILL USE TO ANSWER

public class Msg_Result extends Message {
    private static final String ELEMENT_INFO = "info";

    private String info;

    public Msg_Result() {
        super();
    }

    @Override
    protected void receiveAttributes(ArrayList<NameValue> pairs) {
        this.info = findAttribute(pairs, ELEMENT_INFO);
    }

    @Override
    protected void sendAttributes(ArrayList<NameValue> pairs) {
        pairs.add(new NameValue(ELEMENT_INFO, this.info));
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
