package Messages;

import java.util.ArrayList;

public class Msg_CreateToDo extends Message{

    private static final String ELEMENT_ID = "id";
    private static final String ELEMENT_TITLE = "title";
    private static final String ELEMENT_PRIORITY = "priority";
    private static final String ELEMENT_DESCRIPTION = "description";

    private int tdID = 0; // id for each to do entry
    private String title; // 3-20 characters
    private String priority; //dunno if enum works here, think it doesn't -> therefore string
    private String description; // 0-255 characters, can be 0.

    public Msg_CreateToDo() {
        super();
    }

    @Override
    protected void receiveAttributes(ArrayList<NameValue> pairs) {
        this.tdID = Integer.parseInt(findAttribute(pairs, ELEMENT_ID)); //trying parseInt so id can stay an integer..
        this.title = findAttribute(pairs, ELEMENT_TITLE);
        this.priority = findAttribute(pairs, ELEMENT_PRIORITY);
        this.description = findAttribute(pairs, ELEMENT_DESCRIPTION);
    }

    @Override
    protected void sendAttributes(ArrayList<NameValue> pairs) {
        pairs.add(new NameValue(ELEMENT_ID, Integer.toString(this.tdID)));
        pairs.add(new NameValue(ELEMENT_TITLE, this.title));
        pairs.add(new NameValue(ELEMENT_PRIORITY, this.priority));
        pairs.add(new NameValue(ELEMENT_DESCRIPTION, this.description));
    }

    public int getTdID() {
        tdID++;
        return tdID;
    }

    public void setTdID(int tdID) {
        this.tdID = tdID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
