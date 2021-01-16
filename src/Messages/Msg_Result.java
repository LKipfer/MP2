package Messages;

import java.util.ArrayList;

//THIS IS THE ONLY MESSAGE THAT THE SERVER WILL USE TO ANSWER

public class Msg_Result extends Message {
    private static final String ELEMENT_USERNAME = "username";
    private static final String ELEMENT_PASSWORD = "password";

    private static final String ELEMENT_TODOID = "id";
    private static final String ELEMENT_TITLE = "title";
    private static final String ELEMENT_PRIORITY = "priority";
    private static final String ELEMENT_DESCRIPTION = "description";

    private String username;
    private String password;

    private int tdID = 0; // id for each to do entry
    private String title; // 3-20 characters
    private String priority; //dunno how enum works here, think it doesn't -> therefore string
    private String description; // 0-255 characters, can be 0.


    public Msg_Result() {
        super();
    }

    @Override
    protected void receiveAttributes(ArrayList<NameValue> pairs) {
        this.username = findAttribute(pairs, ELEMENT_USERNAME);
        this.password = findAttribute(pairs, ELEMENT_PASSWORD);

        this.tdID = Integer.parseInt(findAttribute(pairs, ELEMENT_TODOID)); //trying parseInt so id can stay an integer..
        this.title = findAttribute(pairs, ELEMENT_TITLE);
        this.priority = findAttribute(pairs, ELEMENT_PRIORITY);
        this.description = findAttribute(pairs, ELEMENT_DESCRIPTION);

    }

    @Override
    protected void sendAttributes(ArrayList<NameValue> pairs) {
        pairs.add(new NameValue(ELEMENT_USERNAME, this.username));
        pairs.add(new NameValue(ELEMENT_PASSWORD, this.password));

        pairs.add(new NameValue(ELEMENT_TODOID, Integer.toString(this.tdID)));
        pairs.add(new NameValue(ELEMENT_TITLE, this.title));
        pairs.add(new NameValue(ELEMENT_PRIORITY, this.priority));
        pairs.add(new NameValue(ELEMENT_DESCRIPTION, this.description));
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTdID() {
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
