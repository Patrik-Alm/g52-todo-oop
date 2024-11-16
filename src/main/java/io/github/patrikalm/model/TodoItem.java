package io.github.patrikalm.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TodoItem {

    private static int sequencer = 1000;
    private int id;
    private String title;
    private String taskDescription;

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private String deadLineDate;
    private LocalDate deadLine;
    private boolean done = false;
    private Person creator;


    public TodoItem(String title, String taskDescription, String deadLineDate, Person creator) {

        id = sequencer++;
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLineDate);
        setCreator(creator);
    }

    public int getId() {
       //changed due to DAO implementation to public and to return int id
        return this.id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {



        if (title == null || title.equals(" ")) {
            throw new IllegalArgumentException("Can not be null or empty.");
        }

        this.title = title;
    }

    public String getTaskDescription() {

        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {

        this.taskDescription = taskDescription;

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

    public void setDone() {

        this.done = true;
    }

    public boolean isDone() {

        return done;
    }

    public Person getCreator() {

        return creator;
    }

    public void setCreator(Person creator) {

        this.creator = creator;
    }

    public boolean isOverdue() {

        return LocalDate.now().isAfter(getDeadLine());
    }

   /* public String getSummary() {

        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append("Todo id: ");
        sb.append(id);
        sb.append(System.lineSeparator());
        sb.append("Task: ");
        sb.append(title);
        sb.append(System.lineSeparator());
        sb.append("Description: ");
        sb.append(taskDescription);
        sb.append(System.lineSeparator());
        sb.append("Deadline: ");
        sb.append(deadLine);
        sb.append(System.lineSeparator());
        sb.append("Created by: ");
        sb.append(creator.getFirstName());
        sb.append(" ");
        sb.append(creator.getLastName());
        sb.append(", Email: ");
        sb.append(creator.getEmail());
        sb.append(System.lineSeparator());
        sb.append("Status: ");

        if (isDone()) {
            sb.append("The task is done.");
        }
        else if (isOverdue()) {
            sb.append("The task is overdue.");
        }
        else {
            sb.append("The task is not done");
        }

        return sb.toString();
    } */

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append("Todo id: ");
        sb.append(id);
        sb.append(System.lineSeparator());
        sb.append("Task: ");
        sb.append(title);
        sb.append(System.lineSeparator());
        sb.append("Description: ");
        sb.append(taskDescription);
        sb.append(System.lineSeparator());
        sb.append("Deadline: ");
        sb.append(deadLine);
        sb.append(System.lineSeparator());
        sb.append("Status: ");

        if (isDone()) {
            sb.append("The task is done.");
        }
        else if (isOverdue()) {
            sb.append("The task is overdue.");
        }
        else {
            sb.append("The task is not done");
        }

        return sb.toString();

    }

    @Override
    public boolean equals(Object obj) {

        TodoItem localTodoItem = (TodoItem) obj;

        if (this.id == localTodoItem.id
        && this.title == localTodoItem.title
        && this.taskDescription == localTodoItem.taskDescription
        && this.deadLine == localTodoItem.deadLine) {

            return true;
        }

        return false;
    }

   @Override
    public int hashCode() {

        return title.hashCode() + taskDescription.hashCode() + deadLine.hashCode();
   }

}
