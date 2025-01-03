package io.github.patrikalm.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class Todo {

    private String title;
    private String description;

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private String deadLineDate;
    private LocalDate deadLine;
    private boolean done = false;
    private int id = 0;
    private int assigneeId = 0;


    public Todo(String title, String description, String deadLineDate) {

        setTitle(title);
        setDescription(description);
        setDeadLine(deadLineDate);
    }

    public Todo(int id, String title, String description, String deadLineDate, boolean done, int assigneeId) {
        this(title, description, deadLineDate);
        this.id = id;
        this.done = done;
        this.assigneeId = assigneeId;
    }

    public int getId() {

        return this.id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        // TODO - The instance must at least have a title, assumption done here
        if (title == null || title.equals(" ")) {
            throw new IllegalArgumentException("Can not be null or empty.");
        }

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;

    }

    public LocalDate getDeadLine() {

        return deadLine;
    }

    public void setDeadLine(String deadLineDate) {

        if (deadLineDate == null || deadLineDate.equals(" "))  {

            throw new DateTimeParseException("Can not be null or empty", " ", 0);
        }

        this.deadLine = LocalDate.parse(deadLineDate, dateFormat);
    }

    public int getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(int assigneeId) {
        // Can also be set by constructor

        this.assigneeId = assigneeId;
    }

    public void setDone(boolean doneStatus) {

        this.done = doneStatus;
    }

    public boolean isDone() {

        return this.done;
    }

   public void setId(int id) {
        // Not to use except when adding a new instance to the database.
        this.id = id;
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append("Todo id: ");
        sb.append(id);
        sb.append(System.lineSeparator());
        sb.append("Todo title: ");
        sb.append(title);
        sb.append(System.lineSeparator());
        sb.append("Description: ");
        sb.append(description);
        sb.append(System.lineSeparator());
        sb.append("Deadline: ");
        sb.append(deadLine);
        sb.append(System.lineSeparator());
        sb.append("Status: ");

        if (isDone()) {
            sb.append("The task is done.");
        }
        else {
            sb.append("The task is not done");
        }

        sb.append(System.lineSeparator());
        sb.append("AssigneeID: ");

        if (getAssigneeId() == 0) {
            sb.append("No assignee registered.");
        }
        else if (getAssigneeId() > 0) {
            sb.append(getAssigneeId());
        }
        else {
            sb.append("Something is wrong with the ID code ").append(getAssigneeId());
        }

        return sb.toString();
    }



    @Override
    public boolean equals(Object obj) {

        // No additional variables added as this existing fields will be sufficient to evaluate equality

        Todo localTodo = (Todo) obj;

        return this.id == localTodo.id
                && Objects.equals(this.title, localTodo.title)
                && Objects.equals(this.description, localTodo.description)
                && this.deadLine == localTodo.deadLine;
    }

   @Override
    public int hashCode() {

        return title.hashCode() + description.hashCode() + deadLine.hashCode();
   }


}
