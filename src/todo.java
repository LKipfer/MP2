import java.time.LocalDate;

public class todo {

    int id;             // a unique ID number, generated by the system
    String title;       // a title of 3-20 characters
    enum Priority {low, medium, high}   // dunno if enum works here
    String description; // a description of 0-255 characters
    LocalDate dueDate;  // dunno if LocalDate works here.. p.11 on slide








    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
