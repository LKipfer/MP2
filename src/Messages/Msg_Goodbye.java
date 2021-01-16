package Messages;

import java.util.ArrayList;

public class Msg_Goodbye extends Message {

    private static final String ELEMENT_GOODBYE = "goodbye";

    private String goodbye = "Goodbye!";


    public Msg_Goodbye() {
        super();
    }



    @Override
    protected void receiveAttributes(ArrayList<NameValue> pairs) {
        this.goodbye = findAttribute(pairs, ELEMENT_GOODBYE);
    }

    @Override
    protected void sendAttributes(ArrayList<NameValue> pairs) {
        pairs.add(new NameValue(ELEMENT_GOODBYE, this.goodbye));
    }

    public String getGoodbye() {
        return goodbye;
    }

    public void setGoodbye(String goodbye) {
        this.goodbye = goodbye;
    }
}
